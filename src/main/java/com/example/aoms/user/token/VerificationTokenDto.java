package com.example.aoms.user.token;

import com.example.aoms.user.UserDto;
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
