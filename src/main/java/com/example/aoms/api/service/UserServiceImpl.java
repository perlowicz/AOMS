package com.example.aoms.api.service;

import com.example.aoms.api.jwt_token.service.JwtService;
import com.example.aoms.api.data.UserInfoResponse;
import com.example.aoms.api.data.VerificationTokenInfo;
import com.example.aoms.api.dto.user.UserDto;
import com.example.aoms.api.data.RegisterRequest;
import com.example.aoms.api.dto.user.VerificationTokenDto;
import com.example.aoms.api.entity.user.User;
import com.example.aoms.api.entity.user.VerificationToken;
import com.example.aoms.api.exception.UserAlreadyExistsException;
import com.example.aoms.api.exception.UserNotFoundException;
import com.example.aoms.api.mapper.UserMapper;
import com.example.aoms.api.mapper.VerificationTokenMapper;
import com.example.aoms.api.repository.UserRepository;
import com.example.aoms.api.repository.VerificationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import static com.example.aoms.api.mapper.UserMapper.mapDtoToEntity;
import static com.example.aoms.api.mapper.UserMapper.mapEntityToDto;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final VerificationTokenRepository tokenRepository;
    private final JwtService jwtService;


    @Override
    public Optional<UserDto> findDtoByEmail(String email) {
        return findUserByEmail(email)
                .map(UserMapper::mapEntityToDto);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public UserDto registerUser(RegisterRequest registerRequest) {
        String userEmail = registerRequest.getEmail();
        if (userRepository.findByEmail(userEmail).isPresent()) {
            throw new UserAlreadyExistsException("User with email " + userEmail + " already exists in database");
        }
        User newUser = mapDtoToEntity(registerRequest, passwordEncoder);
        User savedUser = userRepository.save(newUser);
        return mapEntityToDto(savedUser);
    }

    @Override
    public void saveUserVerificationToken(VerificationTokenDto dto, Long userId) {
        userRepository.findById(userId)
                .ifPresentOrElse(
                        user -> {
                            VerificationToken entity = VerificationTokenMapper.mapDtoToEntity(dto, user);
                            tokenRepository.save(entity);
                        }, () -> {
                            throw new UserNotFoundException("User with id: " + userId + " doesn't exists in database");
                        });
    }

    @Override
    public VerificationTokenInfo validateToken(String token) {
        VerificationToken verificationToken = tokenRepository.findByToken(token);
        if(verificationToken == null){
            return VerificationTokenInfo.builder()
                    .isValid(false)
                    .message("Invalid verification token")
                    .build();
        }
        User user = verificationToken.getUser();
        if (verificationToken.getExpirationTime().isBefore(Instant.now())){
            return VerificationTokenInfo.builder()
                    .isValid(false)
                    .message("Verification link already expired")
                    .build();
        }
        user.setIsEnabled(true);
        userRepository.save(user);
        return VerificationTokenInfo.builder()
                .isValid(true)
                .message("Verification token valid")
                .build();
    }

    @Override
    public VerificationToken generateNewVerificationToken(String oldToken) {
        VerificationToken verificationToken = tokenRepository.findByToken(oldToken);
        var tokenExpirationTime = new VerificationToken();
        verificationToken.setToken(UUID.randomUUID().toString());
        verificationToken.setExpirationTime(tokenExpirationTime.getExpirationTime());
        return tokenRepository.save(verificationToken);
    }

    @Override
    public UserInfoResponse findUserInfoByJwt(String jwt) {
        Long userId = jwtService.extractUserId(jwt);
        return userRepository.findById(userId)
                .map(entity -> {
                    UserDto userDto = mapEntityToDto(entity);
                    return UserInfoResponse.builder()
                            .userDto(userDto)
                            .found(true)
                            .build();
                })
                .orElseGet(() -> UserInfoResponse.builder()
                        .found(false)
                        .errorMessage(String.format("User with id %s not found", userId))
                        .build());
    }
}
