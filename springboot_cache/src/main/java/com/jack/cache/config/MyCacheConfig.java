package com.jack.cache.config;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author PC20
 * @create 2019/8/12
 */
@Configuration
public class MyCacheConfig {

    @Bean("MyKeyGenerator")
    public KeyGenerator keyGenerator(){
       return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                return method.getName()+"["+ Arrays.asList(objects)+"]";
            }
        };
    }

    /*@Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new AccessControlAllowOriginFilter()); // 自己的filter

        *//*List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/openapi/*");
        registrationBean.setUrlPatterns(urlPatterns);*//*
        return registrationBean;
    }*/
}
