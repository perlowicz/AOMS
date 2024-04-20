package com.example.aoms.api.jwt_token.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    String generateToken(UserDetails userDetails);
    String generateRefreshToken(UserDetails userDetails);
    String extractEmail(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
    boolean expired(String token);
}
