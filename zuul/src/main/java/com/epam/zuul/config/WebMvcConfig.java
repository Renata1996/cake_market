package com.epam.zuul.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {


    private static final String DEFAULT_PATH = "/";
    private static final String DEFAULT_PATH_VIEW = "index";
    private static final String LOGIN_PATH = "/login";
    private static final String LOGIN_PATH_VIEW = "login";
    private static final String REGISTRATION_PATH = "/registration";
    private static final String REGISTRATION_PATH_VIEW = "registration";


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(LOGIN_PATH).setViewName(LOGIN_PATH_VIEW);
        registry.addViewController(DEFAULT_PATH).setViewName(DEFAULT_PATH_VIEW);
        registry.addViewController(REGISTRATION_PATH).setViewName(REGISTRATION_PATH_VIEW);
    }

}
