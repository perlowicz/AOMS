package com.example.aoms.user.token;

public interface VerificationTokenService {
    VerificationTokenDto findByToken(String token);
}
