package com.example.autumn.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Jagi
 * @Date 2020/11/29
 */

@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Value("${web.upload-path}")
    private String mImagesPath;

    /**
     * 映射图片访问地址和实际地址
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("file:" + mImagesPath);
    }



}
