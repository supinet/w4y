package com.w4you.discoveryserver.config;

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
