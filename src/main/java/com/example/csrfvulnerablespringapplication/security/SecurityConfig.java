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

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().anyRequest().authenticated();
//       --2-- Comment this line to enable CSRF token
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
                        .username("banker")
                        .password("money123")
                        .authorities("ROLE_USER")
                        .build());
    }

}
