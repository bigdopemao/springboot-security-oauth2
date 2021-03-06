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
    // 隐式模式
    // http://localhost:8080/oauth/authorize?client_id=client-a&redirect_uri=http://localhost:9001/callback&response_type=token&scope=read_user_info
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
