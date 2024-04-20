package com.example.aoms.config;

import com.example.aoms.security.filter.JwtAuthenticationFilter;
import com.example.aoms.security.oauth2.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
//    private final CustomOAuth2UserService customOAuth2UserService;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((
                        authorize ->
                                authorize
                                        .requestMatchers(
                                                "/user/register/**",
                                                "/user/register/verifyEmail",
                                                "/user/login/**"
//                                                "/service",
//                                                "/info",
//                                                "/product",
//                                                "/address",
//                                                "/company",
//                                                "/customer",
//                                                "/invoice/**"
                                        )
                                        .permitAll()
//                                        .requestMatchers("/secret").hasAuthority("USER")
//                                        .requestMatchers("/oauth2").authenticated()
                                        .anyRequest().hasAuthority("USER")
                        ))
//                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
//                .formLogin(withDefaults())
//                .oauth2Login(configurer -> configurer.userInfoEndpoint(endpoint -> endpoint.userService(customOAuth2UserService)))
                .build();
    }
}
