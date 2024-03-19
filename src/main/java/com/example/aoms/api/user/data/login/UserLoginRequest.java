package com.example.aoms.api.user.data.login;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRequest {
    private String username;
    private String password;
}
