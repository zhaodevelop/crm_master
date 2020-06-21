package com.ruanyuan.crm_master.Intercepter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Configer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List list = new ArrayList();
        registry.addInterceptor(new Interceptor()).addPathPatterns("/**").excludePathPatterns("/Employee/login");
    }
}
