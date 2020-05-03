package com.mao.oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

/**
 * 这里记个坑：
 * 1. 重写了configure(AuthenticationManagerBuilder auth)方法提供登录用户信息时，无需再在AuthenticationManager
 * 和UserDetailsService中再写一遍查用户信息的操作
 * 2. 声明bean为UserDetailsService不要使用super.userDetailsServiceBean()，当刷新token时会造成StackOverFlow，
 * 转而使用super.userDetailsService()便好
 * @author bigdope
 * @create 2020-03-18
 **/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("mao")
                .password(passwordEncoder().encode("123456"))
                .authorities(Collections.emptyList());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated() // 所有请求都需要通过认证
                .and()
                .httpBasic() // Basic提交
                .and()
                .csrf().disable(); // 关跨域保护
    }
}
