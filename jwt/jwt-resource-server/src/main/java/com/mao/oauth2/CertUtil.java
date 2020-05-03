package com.mao.oauth2;

import sun.misc.BASE64Encoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.security.*;
import java.security.cert.Certificate;

/**
 * 根据 keystore 或 jks 获取公钥和私钥
 * @author bigdope
 * @create 2020-03-19
 **/
public class CertUtil {

    // 秘钥文件地址
    private File keystoreFile;
    // 秘钥文件类型
    private String keyStoreType;
    // 密码
    private char[] password;
    // 别名
    private String alias;
    // 导出文件地址
    private File exportedFile;

    /**
     * 获取私钥
     * @param keystore
     * @param alias
     * @param password
     * @return
     */
    private KeyPair getPrivateKey(KeyStore keystore, String alias, char[] password) {
        try {
            Key key = keystore.getKey(alias, password);
            if (key instanceof PrivateKey) {
                Certificate cert = keystore.getCertificate(alias);
                PublicKey publicKey = cert.getPublicKey();
                return new KeyPair(publicKey, (PrivateKey) key);
            }
        }catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void export()throws Exception {
        KeyStore keystore = KeyStore.getInstance(keyStoreType);
        BASE64Encoder encoder =new BASE64Encoder();
        keystore.load(new FileInputStream(keystoreFile), password);
        KeyPair keyPair = getPrivateKey(keystore, alias, password);
        PrivateKey privateKey = keyPair.getPrivate();
        String encoded = encoder.encode(privateKey.getEncoded());
        FileWriter fw =new FileWriter(exportedFile);
        fw.write("-----BEGIN PRIVATE KEY-----\r\n");
        fw.write(encoded);
//        fw.write("\n");
        fw.write("\r\n-----END PRIVATE KEY-----\r\n\r\n");

        Certificate cert = keystore.getCertificate(alias);
        PublicKey publicKey = cert.getPublicKey();
        String encoded2 = encoder.encode(publicKey.getEncoded());
        fw.write("-----BEGIN PUBLIC KEY-----\r\n");
        fw.write(encoded2);
//        fw.write("\n");
        fw.write("\r\n-----END PUBLIC KEY-----\r\n");
        fw.close();
    }

    public static void main(String args[])throws Exception {
        CertUtil export =new CertUtil();
        export.keystoreFile =new File("d:/data/test.jks");
        export.keyStoreType ="JKS";
        export.password ="mypass".toCharArray();
        export.alias ="mytest";
        export.exportedFile =new File("d:/data/testPubKey.cert");
        export.export();
    }

}
