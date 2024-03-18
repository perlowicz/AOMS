package com.example.aoms.api.user.dto.login;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginResponse {
    private Boolean isUserValid;
    private String jwtToken;
}
