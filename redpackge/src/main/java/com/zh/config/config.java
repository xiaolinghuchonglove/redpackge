package com.zh.config;

import com.zh.interceptor.hasloginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class config implements WebMvcConfigurer {
    @Autowired
    hasloginInterceptor hasloginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(hasloginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/registy", "/login");
        System.out.println("配置成功");
    }
}
