package com.w4you.discoveryserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

//@Configuration
public class SecurityConfig {

//    @Value("${eureka.username}")
//    private String username;
//
//    @Value("${eureka.password}")
//    private String password;
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = User.withUsername(username)
//                .passwordEncoder(passwordEncoder()::encode)
//                .password(password)
//                .authorities("USER")
//                .build();
//        return new InMemoryUserDetailsManager(Collections.singleton(user));
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        Map<String, PasswordEncoder> encoders = new HashMap<>();
//        encoders.put("noop", NoOpPasswordEncoder.getInstance());
//        return new DelegatingPasswordEncoder("noop", encoders);
//    }
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return web -> web.ignoring().requestMatchers("/css/**", "/js/**", "/img/**", "/lib/**", "/favicon.ico");
//    }
}
