package com.hannt.example.court.web;

import com.hannt.example.court.config.CourtConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class CourtWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{CourtConfiguration.class};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }
}
