package com.example.aoms.user;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto {
    Long id;
    String userName;
    String email;
    String password;
    String role;
    Boolean isEnabled;

}
