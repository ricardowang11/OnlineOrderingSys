package com.team.boot.config;

import com.team.boot.interceptor.LoginInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: wangqin
 * @Date: 2021/3/1 0001 - 03 -01 -21:37
 * @Description: com.team.boot.config
 * @version: 1.0
 */
@Component
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/index.html")
                .excludePathPatterns("/")
                .excludePathPatterns("/static/**")
                .excludePathPatterns("/sign/**")
                .excludePathPatterns("/signin","/signup");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

    }
}
