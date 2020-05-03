package com.mao.oauth2.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * https://www.cnblogs.com/hellxz/p/oauth2_oauthcode_pattern.html
 * @author bigdope
 * @create 2020-03-05
 **/
@EnableResourceServer
@SpringBootApplication
public class ResourceServer2Application {

    public static void main(String[] args) {
        SpringApplication.run(ResourceServer2Application.class, args);
    }

}
