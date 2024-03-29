package com.example.aoms.api.jwt_token.mapper;

import com.example.aoms.api.jwt_token.dto.JwtTokenDto;
import com.example.aoms.api.jwt_token.entity.JwtToken;
import com.example.aoms.api.user.entity.User;

public class JwtTokenMapper {

    public static JwtToken mapDtoToEntity(JwtTokenDto dto, User user) {
        JwtToken entity = new JwtToken();
        entity.setToken(dto.getToken());
        entity.setRevoked(dto.getRevoked());
        entity.setExpired(dto.getExpired());
        entity.setUser(user);
        return entity;
    }
}
