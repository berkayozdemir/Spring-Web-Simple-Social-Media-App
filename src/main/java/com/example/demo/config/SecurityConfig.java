package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeRequests().mvcMatchers("/login").permitAll()
                .mvcMatchers("/homepage").authenticated()
                .mvcMatchers("/signup").permitAll()
                .mvcMatchers("signupPerson").permitAll()
                .mvcMatchers("/savePost").permitAll()
                .mvcMatchers("/api/**").authenticated()
                .mvcMatchers("/postPage").authenticated().and()
                .formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/homepage").permitAll().failureUrl("/login")
                .and().logout().logoutUrl("/performLogout").invalidateHttpSession(true).permitAll().and().httpBasic();




    }



    //was used for in memory auths at the beginning of the project

/*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().withUser("admin").password("12345").roles("ADMIN").and()
                .withUser("BERKAY").password("1234").roles("USER").and().passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
*/



}