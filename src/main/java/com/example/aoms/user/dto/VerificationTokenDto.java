package com.example.aoms.user.dto;

import com.example.aoms.user.dto.UserDto;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
public class VerificationTokenDto {
    private String token;
    private Instant expirationTime;
    private UserDto userDto;
}
