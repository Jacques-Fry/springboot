package com.jacques.common.config;

/**
 * @author Jack_YD
 * @create 2019/8/21 9:58
 */
import com.jacques.common.utils.pathUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileConfig implements WebMvcConfigurer {

    //将jar文件下的对应静态资源文件路径对应到磁盘的路径(根据个人的情况修改"file:static/"的static的值)
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").
                addResourceLocations("classpath:/static/","file:"+new pathUtils().getPath()+"/static/");
    }




}
