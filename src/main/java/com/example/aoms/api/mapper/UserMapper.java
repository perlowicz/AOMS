package com.example.aoms.api.mapper;

import com.example.aoms.api.data.userRegistration.UserRegistrationData;
import com.example.aoms.api.dto.user.UserDto;
import com.example.aoms.api.entity.user.Role;
import com.example.aoms.api.entity.user.User;
import com.example.aoms.api.data.userRegistration.RegistrationRequest;
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

//    public static User mapDtoToEntity(RegistrationRequest registrationRequest, PasswordEncoder passwordEncoder) {
//        User user = new User();
//        user.setUserName(registrationRequest.getUserRegistrationData().g);
//        user.setEmail(registrationRequest.getEmail());
//        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
//        user.setRole(Role.valueOf("USER"));
//        return user;
//    }

    public static UserDto mapUserRegistrationDataToUserDto(UserRegistrationData userRegistrationData) {
        return UserDto.builder()
                .userName(userRegistrationData.getUserName())
                .email(userRegistrationData.getEmail())
                .password(userRegistrationData.getPassword())
                .role("USER")
                .build();
    }
}
