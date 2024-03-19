package com.example.aoms.api.user.service;

import com.example.aoms.api.user.data.token.VerificationTokenInfo;
import com.example.aoms.api.user.dto.UserDto;
import com.example.aoms.api.user.dto.UserFormDto;
import com.example.aoms.api.user.dto.VerificationTokenDto;
import com.example.aoms.api.user.entity.User;
import com.example.aoms.api.user.entity.VerificationToken;
import com.example.aoms.api.user.exception.UserAlreadyExistsException;
import com.example.aoms.api.user.exception.UserNotFoundException;
import com.example.aoms.api.user.mappers.UserMapper;
import com.example.aoms.api.user.mappers.VerificationTokenMapper;
import com.example.aoms.api.user.repository.UserRepository;
import com.example.aoms.api.user.repository.VerificationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import static com.example.aoms.api.user.mappers.UserMapper.mapDtoToEntity;
import static com.example.aoms.api.user.mappers.UserMapper.mapEntityToDto;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final VerificationTokenRepository tokenRepository;


    @Override
    public Optional<UserDto> findUserById(Long id) {
        return userRepository.findById(id)
                .map(UserMapper::mapEntityToDto);
    }

    @Override
    public UserDto registerUser(UserFormDto userFormDto) {
        String userEmail = userFormDto.getEmail();
        if (userRepository.findByEmail(userEmail).isPresent()) {
            throw new UserAlreadyExistsException("User with email " + userEmail + " already exists in database");
        }
        User newUser = mapDtoToEntity(userFormDto, passwordEncoder);
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
}
