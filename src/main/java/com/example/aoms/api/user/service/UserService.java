package com.example.aoms.api.user.service;

import com.example.aoms.api.user.data.UserInfoResponse;
import com.example.aoms.api.user.verificationToken.VerificationTokenInfo;
import com.example.aoms.api.user.dto.UserDto;
import com.example.aoms.api.user.data.RegisterRequest;
import com.example.aoms.api.user.entity.User;
import com.example.aoms.api.user.entity.VerificationToken;
import com.example.aoms.api.user.dto.VerificationTokenDto;

import java.util.Optional;


public interface UserService {
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserById(Long userId);
    Optional<UserDto> findDtoByEmail(String email);
    UserDto registerUser(RegisterRequest registerRequest);
    void saveUserVerificationToken(VerificationTokenDto dto, Long userId);
    VerificationTokenInfo validateToken(String token);
    VerificationToken generateNewVerificationToken(String oldToken);
    UserInfoResponse findUserInfoByJwt(String jwt);
}
