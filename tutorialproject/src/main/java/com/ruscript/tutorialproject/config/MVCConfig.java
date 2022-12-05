package com.ruscript.tutorialproject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVCConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/home").setViewName("home");
        //registry.addViewController("/").setViewName("home");
        //registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("/Authentication/login");
    }



    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/static/**")
                .addResourceLocations(uploadPath + "/");
        registry.addResourceHandler("/img/**")
                .addResourceLocations(uploadPath + "/");
        registry.addResourceHandler("/image/**")
                .addResourceLocations(uploadPath + "/");
        registry.addResourceHandler("/img/**").
                addResourceLocations("/resources/","/image/", uploadPath + "/");
        registry.addResourceHandler("/static/**").
                addResourceLocations("classpath:");

    }

}
