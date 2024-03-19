package com.example.aoms.api.user.data.login;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginResponse {
    private Boolean isUserValid;
    private String jwtToken;
}
