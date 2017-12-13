package com.epam.zuul.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {


    private static final String DEFAULT_PATH = "/";
    private static final String DEFAULT_PATH_VIEW = "main";
    private static final String LOGIN_PATH = "/login";
    private static final String LOGIN_PATH_VIEW = "login";
    private static final String INDEX_PATH = "/index";
    private static final String INDEX_PATH_VIEW = "index";

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(INDEX_PATH).setViewName(INDEX_PATH_VIEW);
        registry.addViewController(DEFAULT_PATH).setViewName(DEFAULT_PATH_VIEW);
        registry.addViewController(LOGIN_PATH).setViewName(LOGIN_PATH_VIEW);
    }

}
