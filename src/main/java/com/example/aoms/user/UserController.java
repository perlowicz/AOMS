package com.example.aoms.user;

import com.example.aoms.event.RegistrationCompleteEvent;
import com.example.aoms.user.token.VerificationTokenDto;
import com.example.aoms.user.token.VerificationTokenService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ApplicationEventPublisher publisher;
    private final VerificationTokenService verificationTokenService;


    @GetMapping("/users")
    public ResponseEntity<?> getUsers(){
        List<UserDto> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/admin")
    public ResponseEntity<?> adminEndpoint() {
        return ResponseEntity.ok("Endpoint for ADMIN role only");
    }

    @GetMapping("/register")
    public ResponseEntity<?> registrationForm() {
        return ResponseEntity.ok("Registration form");
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserFormDto userFormDto, final HttpServletRequest request){
        UserDto registeredUser = userService.registerUser(userFormDto);
        publisher.publishEvent(new RegistrationCompleteEvent(registeredUser, getApplicationUrl(request)));
        return "Success!  Please, check your email for to complete your registration";
    }

    @GetMapping("/register/verifyEmail")
    public String verifyEmail(@RequestParam("token") String token){
        VerificationTokenDto theToken = verificationTokenService.findByToken(token);
        if (theToken.getUserDto().getIsEnabled()){
            return "This account has already been verified, please, login.";
        }
        String verificationResult = userService.validateToken(token);
        if (verificationResult.equalsIgnoreCase("valid")){
            return "Email verified successfully. Now you can login to your account";
        }
        return "Invalid verification token";
    }

    public String getApplicationUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
