package com.yyh.blogdemo.demo.config;

import com.yyh.blogdemo.demo.component.SecurityInteceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SecurityInteceptor())
                .addPathPatterns("/write","uploadPhoto","submitComment");
    }
}
