package com.wsj.bilibili.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wangshijian
 * @Description:
 * @date 2020/11/2010:42 上午
 */
@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    @Bean
    public LocaleResolverConfig localeResolver(){
        return new LocaleResolverConfig();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login/login");
        registry.addViewController("/login").setViewName("login/login");
        registry.addViewController("/login.html").setViewName("login/login");
        registry.addViewController("/main").setViewName("index");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInceptorConfig()).addPathPatterns("/**")
                .excludePathPatterns("/","/login","/login.html","/user/login","/css/**","/fonts/**","/images/**","/js/**","/vendor/**");
    }
}