package com.example.aoms.database.user.service;

import com.example.aoms.database.user.dto.VerificationTokenDto;

public interface VerificationTokenService {
    VerificationTokenDto findByToken(String token);
}
