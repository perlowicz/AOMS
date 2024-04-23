package com.example.aoms.api.service;

import com.example.aoms.api.jwt_token.service.JwtService;
import com.example.aoms.api.data.AuthenticationRequest;
import com.example.aoms.api.data.AuthenticationResponse;
import com.example.aoms.api.dto.user.UserDto;
import com.example.aoms.api.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    private final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        UserDto userDto = userService.findDtoByEmail(request.getEmail())
                .orElseThrow(() -> {
                    logger.error(String.format("User with email: %s does not exists in database", request.getEmail()));
                    return new UserNotFoundException(String.format("User with email: %s does not exists", request.getEmail()));
                });
        String jwt = jwtService.generateToken(userDto);
        //FIXME Think if i really need refresh token for now (I do not store any data about jwt in db anymore)
        String refreshToken = jwtService.generateRefreshToken(userDto);
        return AuthenticationResponse.builder()
                .accessToken(jwt)
                .refreshToken(refreshToken)
                .build();
    }
}
