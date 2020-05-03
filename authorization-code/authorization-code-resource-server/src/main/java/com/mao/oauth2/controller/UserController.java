package com.mao.oauth2.controller;

import com.mao.oauth2.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bigdope
 * @create 2020-03-05
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    private final static Logger log = LoggerFactory.getLogger(UserController.class);

    // 先获取access_token
    // 授权码模式
    // http://localhost:8080/oauth/authorize?response_type=code&client_id=client-a&redirect_uri=http://localhost:9001/callback
    // 根据上一个请求获得的redirect_uri和code来获取token
    // http://localhost:8080/oauth/token?client_id=client-a&client_secret=client-a-secret&grant_type=authorization_code&scope=read_user_info&redirect_uri=http://localhost:9001/callback&code=RAApd4
    // http://localhost:8081/user/get/1?access_token=a558376d-d025-4aa3-a3df-d478ddfa5e18
    @GetMapping("/get/{id}")
    public User get(@PathVariable Long id) {
        log.info("userId", id);
        User user = new User();
        user.setId(id);
        user.setName("哈哈");
        user.setPassword("123456");
        return user;
    }

}
