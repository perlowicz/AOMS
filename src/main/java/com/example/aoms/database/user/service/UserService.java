package com.example.aoms.database.user.service;

import com.example.aoms.database.user.dto.UserDto;
import com.example.aoms.database.user.dto.UserFormDto;
import com.example.aoms.database.user.entity.VerificationToken;
import com.example.aoms.database.user.dto.VerificationTokenDto;

import java.util.Optional;


public interface UserService {
    Optional<UserDto> findUserById(Long id);
    UserDto registerUser(UserFormDto userFormDto);
    void saveUserVerificationToken(VerificationTokenDto dto, Long userId);
    String validateToken(String token);
    VerificationToken generateNewVerificationToken(String oldToken);

}
