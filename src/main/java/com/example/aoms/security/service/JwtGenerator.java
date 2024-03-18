package com.example.aoms.security.service;

import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class JwtGenerator {

    private final SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();

    String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        long expirationTime = System.currentTimeMillis() + 1000 * 60 * 60 * 10;
        return Jwts.builder()
                .claims(claims)
                .subject(subject)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(expirationTime))
                .signWith(SECRET_KEY)
                .compact();
    }
}
