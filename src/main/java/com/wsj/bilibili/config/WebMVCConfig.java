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
        registry.addViewController("/forgot-password").setViewName("login/forgot-password");
        registry.addViewController("/signup").setViewName("login/signup");
        registry.addViewController("/main").setViewName("index");
        registry.addViewController("/welcome.html").setViewName("welcome");
        registry.addViewController("/goodslist.html").setViewName("goodslist");
        registry.addViewController("/goods-add.html").setViewName("goods-add");
        registry.addViewController("/articletypeadd.html").setViewName("articletypeadd");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInceptorConfig()).addPathPatterns("/**")
                .excludePathPatterns("/","/login","/login.html","/user/login","/forgot-password", "/signup", "/welcome.html",
                        "/css/**","/fonts/**","/images/**","/js/**","/lib/**");
    }
}