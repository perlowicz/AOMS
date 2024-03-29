package com.example.aoms.api.user.service;

import com.example.aoms.api.user.data.AuthenticationRequest;
import com.example.aoms.api.user.data.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
