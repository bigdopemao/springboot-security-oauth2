package com.mao.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * redis作为token存储的授权server
 * @author bigdope
 * @create 2020-03-19
 **/
@SpringBootApplication
public class RedisAuthorizationServer {

    public static void main(String[] args) {
        SpringApplication.run(RedisAuthorizationServer.class, args);
    }

}
