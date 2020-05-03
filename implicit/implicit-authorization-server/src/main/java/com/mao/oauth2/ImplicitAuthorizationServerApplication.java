package com.mao.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 隐式授权模式
 * https://www.cnblogs.com/hellxz/p/oauth2_impilit_pattern.html
 * @author bigdope
 * @create 2020-03-13
 **/
@SpringBootApplication
public class ImplicitAuthorizationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImplicitAuthorizationServerApplication.class, args);
    }

}
