package com.wsj.bilibili.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author wangshijian
 * @Description:
 * @date 2020/11/299:30 下午
 */
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    // 授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin().loginPage("/login").loginProcessingUrl("/user/login").defaultSuccessUrl("/main").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/","/user/login","/main","/css/**","/fonts/**").permitAll()
                .antMatchers("user-add").hasRole("user")
                .anyRequest().authenticated();

        http.headers().frameOptions().disable();
    }
}
