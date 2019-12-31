package com.jacques.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
@MapperScan("com.jacques.common.mapper")
@SpringBootApplication
public class CommonApplication {

  public static void main(String[] args) {
    SpringApplication.run(CommonApplication.class, args);
  }

  @Bean
  public ConfigurableServletWebServerFactory webServerFactory() {
    TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
    factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/index.html"));
    return factory;
  }

}
