package com.example.aoms.api.user.service;

import com.example.aoms.api.user.data.token.VerificationTokenInfo;
import com.example.aoms.api.user.dto.UserDto;
import com.example.aoms.api.user.dto.UserFormDto;
import com.example.aoms.api.user.entity.VerificationToken;
import com.example.aoms.api.user.dto.VerificationTokenDto;

import java.util.Optional;


public interface UserService {
    Optional<UserDto> findUserById(Long id);
    UserDto registerUser(UserFormDto userFormDto);
    void saveUserVerificationToken(VerificationTokenDto dto, Long userId);
    VerificationTokenInfo validateToken(String token);
    VerificationToken generateNewVerificationToken(String oldToken);

}
