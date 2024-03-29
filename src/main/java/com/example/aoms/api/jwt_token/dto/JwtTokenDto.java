package com.example.aoms.api.jwt_token.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtTokenDto {
    private String token;
    private Boolean revoked;
    private Boolean expired;
}
