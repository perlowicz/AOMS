package com.example.aoms.user.mappers;

import com.example.aoms.user.User;
import com.example.aoms.user.UserDto;
import com.example.aoms.user.token.VerificationToken;
import com.example.aoms.user.token.VerificationTokenDto;

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
