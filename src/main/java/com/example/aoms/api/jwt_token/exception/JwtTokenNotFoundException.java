package com.example.aoms.api.jwt_token.exception;

public class JwtTokenNotFoundException extends RuntimeException {
    public JwtTokenNotFoundException(String message) {
        super(message);
    }
}
