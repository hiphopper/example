package com.hannt.example.court.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ViewResolverConfiguration implements WebMvcConfigurer {
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        Map<String, MediaType> mediaTypeMap = new HashMap<>();
        mediaTypeMap.put("html", MediaType.TEXT_HTML);
        mediaTypeMap.put("pdf", MediaType.APPLICATION_PDF);
        mediaTypeMap.put("xls", MediaType.valueOf("application/vnd.ms-excel"));
        mediaTypeMap.put("xml", MediaType.APPLICATION_XML);
        mediaTypeMap.put("json", MediaType.APPLICATION_JSON);

        configurer.mediaTypes(mediaTypeMap);
    }

    @Bean
    public ContentNegotiatingViewResolver contentNegotiatingViewResolver(ContentNegotiationManager contentNegotiationManager){
        ContentNegotiatingViewResolver contentNegotiatingViewResolver = new ContentNegotiatingViewResolver();
        contentNegotiatingViewResolver.setContentNegotiationManager(contentNegotiationManager);
        return contentNegotiatingViewResolver;
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/views/jsp/");
        internalResourceViewResolver.setViewClass(JstlView.class); // jstl.jar가 포함되어 있으면 생략 가능
        internalResourceViewResolver.setSuffix(".jsp");

        return internalResourceViewResolver;
    }
}
