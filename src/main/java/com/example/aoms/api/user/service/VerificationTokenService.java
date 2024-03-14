package com.example.aoms.api.user.service;

import com.example.aoms.api.user.dto.VerificationTokenDto;

public interface VerificationTokenService {
    VerificationTokenDto findByToken(String token);
}
