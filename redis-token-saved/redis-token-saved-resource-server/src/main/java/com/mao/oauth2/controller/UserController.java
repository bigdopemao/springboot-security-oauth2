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
    // 密码模式
    // http://localhost:8080/oauth/token?grant_type=password&username=mao&password=123456&scope=read_scope&client_id=client-a&client_secret=client-a-secret
    // http://localhost:8081/user/get/1?access_token=02c4dce4-0f4b-439c-b90f-1a2a08cf7891
    // http://localhost:8081/user/get/1
    // [{"key":"Authorization","value":"bearer 02c4dce4-0f4b-439c-b90f-1a2a08cf7891","description":""}]
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
