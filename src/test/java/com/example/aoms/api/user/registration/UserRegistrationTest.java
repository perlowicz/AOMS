package com.example.aoms.api.user.registration;

import com.example.aoms.api.controller.UserController;
import com.example.aoms.api.jwt_token.service.JwtService;
import com.example.aoms.api.service.AuthenticationService;
import com.example.aoms.api.service.UserService;
import com.example.aoms.api.service.VerificationTokenService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserRegistrationTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private UserService userService;
    @MockBean
    private AuthenticationService authenticationService;
    @MockBean
    private VerificationTokenService verificationTokenService;
    @MockBean
    private JwtService jwtService;
    @MockBean
    private UserDetailsService userDetailsService;


    @Test
    public void should_create_company_and_user_on_valid_data_for_register_endpoint() throws Exception {
        // TODO
    }
}
