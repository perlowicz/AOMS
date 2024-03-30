package com.example.aoms.api.jwt_token.util;

import jakarta.servlet.http.HttpServletRequest;

public class JwtUtil {

    public static String extractJwtFromRequest(HttpServletRequest request) {
        return request.getHeader("Authorization").substring(7);
    }
}
