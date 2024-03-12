package com.example.aoms.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
public class UserRegistrationSecurityConfig {

    private final List<String> allowedOrigins = List.of("http://localhost:3000");

    private final List<String> allowedMethods = List.of("GET", "POST", "PUT", "DELETE", "OPTIONS");

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((
                        authorize ->
                                authorize
                                        .requestMatchers("/register/**", "/register/verifyEmail").permitAll()
                                        .requestMatchers("/users/**").hasAnyAuthority("USER", "ADMIN")
                                        .requestMatchers("/admin/**").hasAuthority("ADMIN")
                        ))
                .formLogin(Customizer.withDefaults())
                .build();
    }
}
