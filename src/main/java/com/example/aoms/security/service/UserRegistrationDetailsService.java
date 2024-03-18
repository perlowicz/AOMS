package com.example.aoms.security.service;

import com.example.aoms.api.user.dto.login.UserLoginRequest;
import com.example.aoms.api.user.dto.login.UserLoginResponse;
import com.example.aoms.api.user.repository.UserRepository;
import com.example.aoms.security.data.UserRegistrationDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserRegistrationDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtGenerator jwtGenerator;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUserName(username)
                .map(UserRegistrationDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }

    public UserLoginResponse processLoginRequest(UserLoginRequest dto) {
        UserDetails userDetails = loadUserByUsername(dto.getUsername());
        if (userDetails == null) {
            return buildInvalidResponse();
        }
        if (bCryptPasswordEncoder.matches(dto.getPassword(), userDetails.getPassword())) {
            String jwtToken = jwtGenerator.generateToken(userDetails);
            return buildValidResponse(jwtToken);
        }
        return buildInvalidResponse();
    }

    private UserLoginResponse buildInvalidResponse() {
        return UserLoginResponse.builder()
                .isUserValid(false)
                .build();
    }

    private UserLoginResponse buildValidResponse(String jwtToken) {
        return UserLoginResponse.builder()
                .isUserValid(true)
                .jwtToken(jwtToken)
                .build();
    }
}
