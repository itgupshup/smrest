package com.b2e.smrest.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SMRestInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { SMRestConfig.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
 
}