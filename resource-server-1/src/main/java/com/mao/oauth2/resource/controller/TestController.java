package com.mao.oauth2.resource.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bigdope
 * @create 2020-03-04
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    private final static Logger log = LoggerFactory.getLogger(TestController.class);

    // 先获取access_token
    // http://localhost:8080/oauth/token?grant_type=client_credentials&scope=test&client_id=client1&client_secret=123456
    // http://localhost:8081/test/getUserAuth?access_token=a558376d-d025-4aa3-a3df-d478ddfa5e18
    @GetMapping("/getUserAuth")
    public Authentication getUserAuth(Authentication authentication) {
        log.info("resource: user auth {}", authentication);
        return authentication;
    }

}
