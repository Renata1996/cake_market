package cakemanager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    private static final String CAKE_PATH = "/cake";
    private static final String  CAKE_VIEW_NAME="cake";

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(CAKE_PATH).setViewName(CAKE_VIEW_NAME);
    }

}