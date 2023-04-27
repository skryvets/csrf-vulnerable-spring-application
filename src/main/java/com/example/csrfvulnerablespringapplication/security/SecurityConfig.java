package com.example.csrfvulnerablespringapplication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //--1-- Uncomment this bean to enable SOP (Same origin policy) protection
    /*@Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:8080"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }*/

    //--1-- Uncomment this bean to enable SOP (Same origin policy) protection
    //Remove SecurityFilterChain securityFilterChain block below
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http, CorsConfigurationSource corsConfigurationSource) throws Exception {
//        http.authorizeHttpRequests().anyRequest().authenticated();
//        http.cors().configurationSource(corsConfigurationSource);
//        http.formLogin();
//        http.httpBasic();
//        http.userDetailsService(inMemoryUserDetailsManager());
//        return http.build();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().anyRequest().authenticated();
//       --3-- Comment this line to enable CSRF token
        http.csrf().disable();
        http.formLogin();
        http.httpBasic();
        http.userDetailsService(inMemoryUserDetailsManager());
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        return new InMemoryUserDetailsManager(
            User.withDefaultPasswordEncoder()
                        .username("john")
                        .password("doe")
                        .authorities("ROLE_USER")
                        .build());
    }

}
