package com.example.aoms.api.user.mappers;

import com.example.aoms.api.user.dto.UserDto;
import com.example.aoms.api.user.entity.User;
import com.example.aoms.api.user.entity.VerificationToken;
import com.example.aoms.api.user.dto.VerificationTokenDto;

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
