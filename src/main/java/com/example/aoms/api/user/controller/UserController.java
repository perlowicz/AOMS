package com.example.aoms.api.user.controller;

import com.example.aoms.api.user.dto.*;
import com.example.aoms.api.user.dto.login.UserLoginRequest;
import com.example.aoms.api.user.dto.login.UserLoginResponse;
import com.example.aoms.api.user.event.RegistrationCompleteEvent;
import com.example.aoms.api.user.service.UserService;
import com.example.aoms.api.user.service.VerificationTokenService;
import com.example.aoms.security.service.UserRegistrationDetailsService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ApplicationEventPublisher publisher;
    private final VerificationTokenService verificationTokenService;
    private final UserRegistrationDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequest dto) {
        UserLoginResponse response = userDetailsService.processLoginRequest(dto);
        if (response.getIsUserValid()) {
            return ResponseEntity.ok(response.getJwtToken());
        }
        return ResponseEntity
                .badRequest()
                .body("Invalid username or password");
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserFormDto userFormDto, final HttpServletRequest request){
        UserDto registeredUser = userService.registerUser(userFormDto);
        publisher.publishEvent(new RegistrationCompleteEvent(registeredUser, getApplicationUrl(request)));
        return ResponseEntity.ok("User created");
    }

    @GetMapping("/register/verifyEmail")
    public ResponseEntity<?> verifyEmail(@RequestParam("token") String token){
        VerificationTokenDto theToken = verificationTokenService.findByToken(token);
        if (theToken.getUserDto().getIsEnabled()){
            return ResponseEntity
                    .badRequest()
                    .body("Email already verified. Please login to your account.");
        }
        String verificationResult = userService.validateToken(token);
        if (verificationResult.equalsIgnoreCase("valid")){
            return ResponseEntity.ok("Email validated properly");
        }
        return ResponseEntity
                .badRequest()
                .body("Invalid token");
    }

    private String getApplicationUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
