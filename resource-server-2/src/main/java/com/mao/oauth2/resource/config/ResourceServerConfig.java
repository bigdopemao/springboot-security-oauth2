package com.mao.oauth2.resource.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

/**
 * @author bigdope
 * @create 2020-03-05
 **/
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Primary
    @Bean
    public RemoteTokenServices remoteTokenServices() {
        final RemoteTokenServices tokenServices = new RemoteTokenServices();
        // 设置授权服务器check_token端点完整地址
        tokenServices.setCheckTokenEndpointUrl("http://localhost:8080/oauth/check_token");
        // 设置客户端id与secret，注意：client_secret值不能使用passwordEncoder加密！
        tokenServices.setClientId("client1");
        tokenServices.setClientSecret("123456");
        return tokenServices;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // 设置创建session策略
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
        // @formatter:off
        // 所有请求必须授权
        http.authorizeRequests()
                .anyRequest().authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("resource1").stateless(true);
    }
}
