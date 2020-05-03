package com.mao.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 客户端模式
 * @author bigdope
 * @create 2020-03-13
 **/
@SpringBootApplication
public class ClientCredentialsAuthorizationApp {

    public static void main(String[] args) {
        SpringApplication.run(ClientCredentialsAuthorizationApp.class, args);
    }

}
