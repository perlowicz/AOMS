package com.example.aoms.api.user.controller;

import com.example.aoms.api.user.data.*;
import com.example.aoms.api.user.service.AuthenticationService;
import com.example.aoms.api.user.verificationToken.VerificationTokenInfo;
import com.example.aoms.api.user.dto.UserDto;
import com.example.aoms.api.user.dto.VerificationTokenDto;
import com.example.aoms.api.user.event.RegistrationCompleteEvent;
import com.example.aoms.api.user.service.UserService;
import com.example.aoms.api.user.service.VerificationTokenService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ApplicationEventPublisher publisher;
    private final VerificationTokenService verificationTokenService;
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) {
        AuthenticationResponse response = authenticationService.authenticate(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<?> authenticate(){
        return ResponseEntity.ok("Authenticated");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest, final HttpServletRequest request){
        UserDto registeredUser = userService.registerUser(registerRequest);
        publisher.publishEvent(new RegistrationCompleteEvent(registeredUser, getApplicationUrl(request)));
        return ResponseEntity.ok("User created");
    }

    @GetMapping("/register/verifyEmail")
    public ResponseEntity<?> verifyEmail(@RequestParam("token") String token){
        VerificationTokenDto verificationTokenDto = verificationTokenService.findByToken(token);
        if (verificationTokenDto.getUserDto().getIsEnabled()){
            return ResponseEntity
                    .badRequest()
                    .body("Email already verified. Please login to your account.");
        }
        VerificationTokenInfo verificationTokenInfo = userService.validateToken(token);
        if (verificationTokenInfo.getIsValid()){
            return ResponseEntity
                    .ok("Email validated properly");
        }
        return ResponseEntity
                .badRequest()
                .body(verificationTokenInfo.getMessage());
    }

    private String getApplicationUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
