package com.example.aoms.api.mapper;

import com.example.aoms.api.dto.user.UserDto;
import com.example.aoms.api.entity.user.User;
import com.example.aoms.api.entity.user.VerificationToken;
import com.example.aoms.api.dto.user.VerificationTokenDto;

public class VerificationTokenMapper {

    public static VerificationTokenDto mapEntityToDto(VerificationToken entity) {
        UserDto userDto = UserMapper.mapEntityToDto(entity.getUser());
        return VerificationTokenDto.builder()
                .token(entity.getToken())
                .expirationTime(entity.getExpirationTime())
                .userDto(userDto)
                .build();
    }

    public static VerificationToken mapDtoToEntity(VerificationTokenDto dto, User user) {
        VerificationToken entity = new VerificationToken();
        entity.setExpirationTime(dto.getExpirationTime());
        entity.setUser(user);
        entity.setToken(dto.getToken());
        return entity;
    }
}
