package com.example.mall.user.config;

import com.example.mall.user.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 加载适配器进行拦截
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * @author dingrui
     * @date 2021/2/21
     * @return
     * @description 自定义的token认证适配器注入spring
     */
    @Bean
    public TokenInterceptor tokenInterceptor() {
        return new TokenInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(tokenInterceptor())
                .addPathPatterns("/user/**")
                .excludePathPatterns("/error");
    }
}
