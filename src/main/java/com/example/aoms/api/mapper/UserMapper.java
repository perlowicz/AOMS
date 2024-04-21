package com.example.aoms.api.mapper;

import com.example.aoms.api.dto.user.UserDto;
import com.example.aoms.api.entity.user.Role;
import com.example.aoms.api.entity.user.User;
import com.example.aoms.api.data.RegisterRequest;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserMapper {

    public static UserDto mapEntityToDto(User entity) {
        return UserDto.builder()
                .id(entity.getId())
                .userName(entity.getUsername())
                .email(entity.getEmail())
                .role(String.valueOf(entity.getRole()))
                .isEnabled(entity.getIsEnabled())
                .build();
    }

    public static User mapDtoToEntity(UserDto userDto, PasswordEncoder passwordEncoder) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(Role.valueOf(userDto.getRole()));
        return user;
    }

    public static User mapDtoToEntity(RegisterRequest registerRequest, PasswordEncoder passwordEncoder) {
        User user = new User();
        user.setUserName(registerRequest.getUserName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole(Role.valueOf("USER"));
        return user;
    }
}
