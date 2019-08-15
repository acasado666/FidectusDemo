package com.casado.rest;


public class SpringSecurityConfig {}

//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//

//    // I will create 2 users for demo
//    // they both have "password" as pasword
//    // user, password
//    // admin, password
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}password").roles("USER")
//                .and()
//                .withUser("admin").password("{noop}password").roles("USER", "ADMIN");
//
//    }
//
//    // Secure the endpoins with HTTP Basic authentication
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http
//                //HTTP Basic authentication
//                .httpBasic()
//                .and()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/financialInstrument/**").hasRole("USER")
//                .antMatchers(HttpMethod.POST, "/financialInstrument").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PUT, "/financialInstrument/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PATCH, "/financialInstrument/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/financialInstrument/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.GET, "/orderBook/**").hasRole("USER")
//                .antMatchers(HttpMethod.POST, "/orderBook").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PUT, "/orderBook/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PATCH, "/orderBook/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/orderBook/**").hasRole("ADMIN")
//                .and()
//                .csrf().disable()
//                .formLogin().disable();
//    }
//}
