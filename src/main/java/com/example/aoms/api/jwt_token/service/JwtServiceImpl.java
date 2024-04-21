package com.example.aoms.api.jwt_token.service;

import com.example.aoms.api.dto.user.UserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {

    private static final String USERNAME_CLAIM_NAME = "username";

    @Value("${application.security.jwt.secret-key}")
    private String secretKey;
    @Value("${application.security.jwt.expiration}")
    private long jwtExpiration;
    @Value("${application.security.jwt.refresh-token.expiration}")
    private long refreshExpiration;


    @Override
    public String generateToken(UserDto userDto) {
        return generateToken(new HashMap<>(), userDto);
    }

    @Override
    public String generateRefreshToken(UserDto userDto) {
        return buildToken(new HashMap<>(), userDto, refreshExpiration);
    }

    @Override
    public String extractEmail(String token) {
        return extractClaim(token, claims -> claims.get(USERNAME_CLAIM_NAME, String.class));
    }

    @Override
    public Long extractUserId(String token) {
        return Long.valueOf(extractClaim(token, Claims::getSubject));
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractEmail(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    @Override
    public boolean expired(String token) {
        return isTokenExpired(token);
    }

    private String generateToken(Map<String, Object> extraClaims, UserDto userDto) {
        return buildToken(extraClaims, userDto, jwtExpiration);
    }

    private String buildToken(Map<String, Object> extraClaims, UserDto userDto, long expiration) {
        return Jwts
                .builder()
                .claims(extraClaims)
                .claim(USERNAME_CLAIM_NAME, userDto.getUserName())
                .subject(String.valueOf(userDto.getId()))
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey())
                .compact();
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(getSignInKey())
                .build().parseSignedClaims(token).getPayload();
    }

    private SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
