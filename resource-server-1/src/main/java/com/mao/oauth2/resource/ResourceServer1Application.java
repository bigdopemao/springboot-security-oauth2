package com.mao.oauth2.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * https://blog.csdn.net/AaronSimon/article/details/83546827
 * @author bigdope
 * @create 2020-03-04
 **/
@EnableResourceServer
@SpringBootApplication
public class ResourceServer1Application {

    public static void main(String[] args) {
        SpringApplication.run(ResourceServer1Application.class, args);
    }

}
