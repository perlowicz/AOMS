package com.example.aoms.user.service;

import com.example.aoms.user.dto.UserDto;
import com.example.aoms.user.dto.UserFormDto;
import com.example.aoms.user.entity.VerificationToken;
import com.example.aoms.user.dto.VerificationTokenDto;

import java.util.Optional;


public interface UserService {
    Optional<UserDto> findUserById(Long id);
    UserDto registerUser(UserFormDto userFormDto);
    void saveUserVerificationToken(VerificationTokenDto dto, Long userId);
    String validateToken(String token);
    VerificationToken generateNewVerificationToken(String oldToken);

}
