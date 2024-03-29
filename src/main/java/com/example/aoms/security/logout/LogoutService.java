package com.example.aoms.security.logout;

import com.example.aoms.api.jwt_token.repository.JwtTokenRepository;
import com.example.aoms.api.jwt_token.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler {

    private final JwtService jwtService;
    private final JwtTokenRepository jwtTokenRepository;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        final String authHeader = request.getHeader("Authorization");
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            return;
        }
        final String jwt = authHeader.substring(7);
        jwtService.findByToken(jwt)
                .ifPresent(jwtToken -> {
                    jwtToken.setExpired(true);
                    jwtToken.setRevoked(true);
                    jwtTokenRepository.save(jwtToken);
                    SecurityContextHolder.clearContext();
                });
    }
}
