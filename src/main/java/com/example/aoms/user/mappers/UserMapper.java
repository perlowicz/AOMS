package com.example.aoms.user.mappers;

import com.example.aoms.user.User;
import com.example.aoms.user.UserDto;
import com.example.aoms.user.UserFormDto;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserMapper {

    public static UserDto mapEntityToDto(User entity) {
        return UserDto.builder()
                .id(entity.getId())
                .userName(entity.getUserName())
                .email(entity.getEmail())
                .role(entity.getRole())
                .isEnabled(entity.getIsEnabled())
                .build();
    }

    public static User mapDtoToEntity(UserDto userDto, PasswordEncoder passwordEncoder) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(userDto.getRole());
        return user;
    }

    public static User mapDtoToEntity(UserFormDto userFormDto, PasswordEncoder passwordEncoder) {
        User user = new User();
        user.setUserName(userFormDto.getUserName());
        user.setEmail(userFormDto.getEmail());
        user.setPassword(passwordEncoder.encode(userFormDto.getPassword()));
        user.setRole("USER");
        return user;
    }
}
