package com.epam.zuul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
@Order(-10)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String LOGIN_PATH = "/login";
    private static final String REGISTRATION_PATH = "/registration";
    private static final String DEFAULT_PATH = "/index";
    private static final String STATIC_PATH = "/**";

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers( REGISTRATION_PATH,DEFAULT_PATH, STATIC_PATH)
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage(LOGIN_PATH)
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and().httpBasic().disable();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // auth.inMemoryAuthentication().withUser("root").password("password").roles("USER");
        auth.jdbcAuthentication().dataSource(dataSource);
    }



}
