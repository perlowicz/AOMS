package com.example.aoms.api.service;

import com.example.aoms.api.dto.user.VerificationTokenDto;

public interface VerificationTokenService {
    VerificationTokenDto findByToken(String token);
}
