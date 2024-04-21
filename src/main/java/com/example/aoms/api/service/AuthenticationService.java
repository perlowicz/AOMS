package com.example.aoms.api.service;

import com.example.aoms.api.data.AuthenticationRequest;
import com.example.aoms.api.data.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
