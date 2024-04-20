package com.example.aoms.api.jwt_token.service;

import com.example.aoms.api.user.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    String generateToken(UserDto userDto);
    String generateRefreshToken(UserDto userDto);
    String extractEmail(String token);
    Long extractUserId(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
    boolean expired(String token);
}
