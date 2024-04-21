package com.example.aoms.api.service;

import com.example.aoms.api.dto.user.VerificationTokenDto;
import com.example.aoms.api.entity.user.VerificationToken;
import com.example.aoms.api.mapper.VerificationTokenMapper;
import com.example.aoms.api.repository.VerificationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerificationTokenServiceImpl implements VerificationTokenService {

    private final VerificationTokenRepository repository;

    @Override
    public VerificationTokenDto findByToken(String token) {
        VerificationToken tokenEntity = repository.findByToken(token);
        return VerificationTokenMapper.mapEntityToDto(tokenEntity);
    }
}
