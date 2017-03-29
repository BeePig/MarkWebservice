package com.example.controller;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configurable
@EnableWebSecurity
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
 
//    @Autowired
//    private RESTAuthenticationEntryPoint authenticationEntryPoint;
//    @Autowired
//    private SimpleUrlAuthenticationFailureHandler authenticationFailureHandler;
//    @Autowired
//    private SimpleUrlAuthenticationSuccessHandler authenticationSuccessHandler;

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManagerBean();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.inMemoryAuthentication().withUser("user").password("user").roles("USER").and().withUser("admin")
                .password("admin").roles("ADMIN");
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/rest/**").authenticated();
        http.csrf().disable();
//        http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
//        http.formLogin().successHandler(authenticationSuccessHandler);
//        http.formLogin().failureHandler(authenticationFailureHandler);
    }
}