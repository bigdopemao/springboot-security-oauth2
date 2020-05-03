package com.mao.oauth2.controller;

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
public class TestTokenEndpointController {

    private final static Logger log = LoggerFactory.getLogger(TestTokenEndpointController.class);

    // 授权服务器，包含四种模式：客户端模式、密码模式、隐式模式、授权码模式

    // 客户端模式
    // 客户端请求token
    // http://localhost:8080/oauth/token?grant_type=client_credentials&scope=test&client_id=client1&client_secret=123456

    // 密码模式
    // 用户请求获取token
    // http://localhost:8080/oauth/token?grant_type=password&username=admin&password=admin&scope=test&client_id=client1&client_secret=123456
    // 注意scope的范围，如下scope为all，就会出错
    // http://localhost:8080/oauth/token?grant_type=password&username=admin&password=admin&scope=all&client_id=client1&client_secret=123456
    // 以下方式就等同于客户端模式
    // http://localhost:8080/oauth/token?grant_type=client_credentials&username=admin&password=admin&scope=test&client_id=client1&client_secret=123456

    // 隐性模式(implicit)
    // http://localhost:8080/oauth/authorize?response_type=token&client_id=client1&redirect_uri=http://www.baidu.com
    // http://localhost:8080/oauth/authorize?response_type=token&client_id=client1&scope=test&redirect_uri=http://www.baidu.com

    // 授权码模式
    // redirect_uri为任意网址，get请求
    // http://localhost:8080/oauth/authorize?response_type=code&client_id=client1&redirect_uri=http://baidu.com
    // 根据上一个请求获得的redirect_uri和code来获取token
    // http://localhost:8080/oauth/token?client_id=client1&client_secret=123456&grant_type=authorization_code&scope=test&redirect_uri=http://baidu.com&code=SXuSR0
    // 或者将client_id和client_secret放入Authorization中
    // http://localhost:8080/oauth/token?grant_type=authorization_code&scope=test&redirect_uri=http://baidu.com&code=SXuSR0


    // 刷新获取token
    // http://localhost:8080/oauth/token?grant_type=refresh_token&client_id=client1&client_secret=123456&refresh_token=2658e64f-3f68-4037-82d3-a0c35433ae87


    // 添加一个测试访问接口
    // http://localhost:8080/test/getUserAuth?access_token=a558376d-d025-4aa3-a3df-d478ddfa5e18
    @GetMapping("/getUserAuth")
    public Authentication getUserAuth(Authentication authentication) {
        log.info("resource: user auth {}", authentication);
        return authentication;
    }

}
