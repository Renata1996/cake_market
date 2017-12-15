package com.epam.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

import javax.sql.DataSource;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableResourceServer
@EnableAuthorizationServer
@EnableJdbcHttpSession
@EnableDiscoveryClient

public class ZuulApplication {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER_NAME = "Renata";
    private static final String PASSWORD = "0000";
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create().url(URL)
                .username(USER_NAME).password(PASSWORD).driverClassName(DRIVER).build();
    }

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }




}


