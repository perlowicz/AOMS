package com.example.aoms.api.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerificationTokenDto {
    private String token;
    private Instant expirationTime;
    private UserDto userDto;
}
