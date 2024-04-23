package com.example.aoms.api.service;

import com.example.aoms.api.data.UserInfoResponse;
import com.example.aoms.api.data.VerificationTokenInfo;
import com.example.aoms.api.dto.user.UserDto;
import com.example.aoms.api.data.userRegistration.RegistrationRequest;
import com.example.aoms.api.entity.user.User;
import com.example.aoms.api.entity.user.VerificationToken;
import com.example.aoms.api.dto.user.VerificationTokenDto;

import java.util.Optional;


public interface UserService {
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserById(Long userId);
    Optional<UserDto> findDtoByEmail(String email);
    UserDto registerUser(RegistrationRequest registrationRequest);
    void saveUserVerificationToken(VerificationTokenDto dto, Long userId);
    VerificationTokenInfo validateToken(String token);
    VerificationToken generateNewVerificationToken(String oldToken);
    UserInfoResponse findUserInfoByJwt(String jwt);
}
