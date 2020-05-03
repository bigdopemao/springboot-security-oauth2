package com.mao.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 授权服务器 入口
 * @author bigdope
 * @create 2020-03-19
 **/
@SpringBootApplication
public class JwtResourceServerApp {

    public static void main(String[] args) {
        SpringApplication.run(JwtResourceServerApp.class, args);
    }

}
