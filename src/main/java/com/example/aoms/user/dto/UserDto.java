package com.example.aoms.user.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto {
    private Long id;
    private String userName;
    private String email;
    private String password;
    private String role;
    private Boolean isEnabled;

}
