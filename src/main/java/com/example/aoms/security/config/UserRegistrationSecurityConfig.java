package com.example.aoms.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

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
                .cors(cors -> cors.configurationSource(request -> {
                    var corsConfig = new CorsConfiguration();
                    corsConfig.setAllowedOrigins(allowedOrigins);
                    corsConfig.setAllowedMethods(allowedMethods);
                    corsConfig.setAllowedHeaders(List.of("*"));
                    return corsConfig;
                }))
                .authorizeHttpRequests((
                        authorize ->
                                authorize
                                        .requestMatchers(
                                                "/user/register/**",
                                                "/user/register/verifyEmail",
                                                "/user/login/**",
                                                "/service",
                                                "/info",
                                                "/product",
                                                "/address",
                                                "/company",
                                                "/customer",
                                                "/invoice/**")
                                        .permitAll()
                                        .requestMatchers(
                                                "/users/**"
                                        ).hasAnyAuthority("USER", "ADMIN")
                                        .requestMatchers(
                                                "/admin/**"
                                        ).hasAuthority("ADMIN")
                        ))
//                .formLogin(Customizer.withDefaults())
                .build();
    }
}
