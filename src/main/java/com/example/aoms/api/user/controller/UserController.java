package com.example.aoms.api.user.controller;

import com.example.aoms.api.jwt_token.util.JwtUtil;
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

    private static final String FRONTEND_EMAIL_VERIFICATION_ENDPOINT = "http://localhost:3000/activate-account";

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) {
        AuthenticationResponse response = authenticationService.authenticate(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<?> authenticate(){
        return ResponseEntity.ok("Authenticated");
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(HttpServletRequest request){
        String jwt = JwtUtil.extractJwtFromRequest(request);
        UserInfoResponse response = userService.findUserInfoByJwt(jwt);
        if (response.isFound()){
            return ResponseEntity.ok(response.getUserDto());
        } else {
            return ResponseEntity.badRequest().body(response.getErrorMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest){
        UserDto registeredUser = userService.registerUser(registerRequest);
        publisher.publishEvent(new RegistrationCompleteEvent(registeredUser, FRONTEND_EMAIL_VERIFICATION_ENDPOINT));
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
}
