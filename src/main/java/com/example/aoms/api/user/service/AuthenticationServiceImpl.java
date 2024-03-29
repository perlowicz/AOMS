package com.example.aoms.api.user.service;

import com.example.aoms.api.jwt_token.dto.JwtTokenDto;
import com.example.aoms.api.jwt_token.entity.JwtToken;
import com.example.aoms.api.jwt_token.repository.JwtTokenRepository;
import com.example.aoms.api.jwt_token.service.JwtService;
import com.example.aoms.api.user.data.AuthenticationRequest;
import com.example.aoms.api.user.data.AuthenticationResponse;
import com.example.aoms.api.user.entity.User;
import com.example.aoms.api.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserService userService;
    private final JwtService jwtService;
    private final JwtTokenRepository jwtTokenRepository;
    private final AuthenticationManager authenticationManager;


    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = userService.findUserByEmail(request.getEmail())
                .orElseThrow(() -> new UserNotFoundException(String.format("User with email: %s does not exists", request.getEmail())));
        String jwt = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        jwtService.save(generateJwtDto(jwt), user);
        return AuthenticationResponse.builder()
                .accessToken(jwt)
                .refreshToken(refreshToken)
                .build();
    }

    private void revokeAllUserTokens(User user) {
        List<JwtToken> validUserTokens = jwtTokenRepository.findAllValidToken(user.getId()).stream()
                .peek(jwtToken -> {
                    jwtToken.setExpired(true);
                    jwtToken.setRevoked(true);
                })
                .collect(Collectors.toList());
        jwtTokenRepository.saveAll(validUserTokens);
    }

    private JwtTokenDto generateJwtDto(String jwt) {
        return JwtTokenDto.builder()
                .token(jwt)
                .expired(false)
                .revoked(false)
                .build();
    }
}
