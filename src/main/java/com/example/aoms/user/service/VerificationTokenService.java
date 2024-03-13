package com.example.aoms.user.service;

import com.example.aoms.user.dto.VerificationTokenDto;

public interface VerificationTokenService {
    VerificationTokenDto findByToken(String token);
}
