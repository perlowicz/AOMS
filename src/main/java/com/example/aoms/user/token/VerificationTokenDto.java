package com.example.aoms.user.token;

import com.example.aoms.user.UserDto;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
public class VerificationTokenDto {
    String token;
    Instant expirationTime;
    UserDto userDto;
}
