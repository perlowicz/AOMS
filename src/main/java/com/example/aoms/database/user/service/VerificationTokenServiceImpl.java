package com.example.aoms.database.user.service;

import com.example.aoms.database.user.dto.VerificationTokenDto;
import com.example.aoms.database.user.entity.VerificationToken;
import com.example.aoms.database.user.mappers.VerificationTokenMapper;
import com.example.aoms.database.user.repository.VerificationTokenRepository;
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
