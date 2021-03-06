package com.mao.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 授权码模式服务器
 * https://www.cnblogs.com/hellxz/p/oauth2_oauthcode_pattern.html
 * @author bigdope
 * @create 2020-03-05
 **/
@SpringBootApplication
public class AuthorizationCodeAuthorizationServerApp {

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationCodeAuthorizationServerApp.class, args);
    }

}
