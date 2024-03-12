package com.example.aoms.user;

import com.example.aoms.user.token.VerificationToken;
import com.example.aoms.user.token.VerificationTokenDto;

import java.util.List;


public interface UserService {
    UserDto registerUser(UserFormDto userFormDto);

    void saveUserVerificationToken(VerificationTokenDto dto, Long userId);

    String validateToken(String token);
    VerificationToken generateNewVerificationToken(String oldToken);
}
