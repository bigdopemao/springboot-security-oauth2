package com.mao.oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;

/**
 * @author bigdope
 * @create 2020-03-19
 **/
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 这里使用的是调用授权服务器接口进行校验token的，除了这种方式，如果授权服务器
     * 将token保存在某些存储器中，可以使用访问存储器来实现
     */
//    @Primary
//    @Bean
//    public RemoteTokenServices remoteTokenServices() {
//        final RemoteTokenServices tokenServices = new RemoteTokenServices();
//        tokenServices.setCheckTokenEndpointUrl("http://localhost:8080/oauth/check_token");
//        tokenServices.setClientId("client-a");
//        tokenServices.setClientSecret("client-a-secret");
//        return tokenServices;
//    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // 设置创建session策略
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
        // 所有请求必须授权
        http.authorizeRequests().anyRequest().authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(jwtTokenStore());
    }

    /**
     * jwt的token存储对象
     */
    @Bean
    public JwtTokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    /**
     * jwt访问token转换器
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        // setSigningKey 和 setVerifierKey 二选一
        // 对称加密算法使用与授权服务器相同的signingKey
//        converter.setSigningKey("my-sign-key");
        Resource resource = new ClassPathResource("test.cert");
        String publicKey;
        try {
            publicKey = new String(FileCopyUtils.copyToByteArray(resource.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        converter.setVerifierKey(publicKey);
        return converter;
    }
}
