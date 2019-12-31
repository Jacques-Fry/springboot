package com.jacques.shiro.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Jack_YD
 * @create 2019/12/25 13:05
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    //设置允许跨域的路径
    registry.addMapping("/**")
        //设置允许跨域请求的域名
        .allowedOrigins("http://192.168.102.251:8080","http://localhost:8080","http://127.0.0.1:8080")
        //是否允许证书 不再默认开启
        .allowCredentials(true)
        //设置允许的方法
        .allowedMethods("POST","GET","DELETE","PUT")
        //跨域允许时间
        .maxAge(3600);
  }
}
