package com.example.aoms.user.token;

import com.example.aoms.user.mappers.VerificationTokenMapper;
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
