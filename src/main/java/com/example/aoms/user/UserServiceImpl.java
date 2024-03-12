package com.example.aoms.user;

import com.example.aoms.user.exception.UserAlreadyExistsException;
import com.example.aoms.user.exception.UserNotFoundException;
import com.example.aoms.user.mappers.VerificationTokenMapper;
import com.example.aoms.user.token.VerificationToken;
import com.example.aoms.user.token.VerificationTokenDto;
import com.example.aoms.user.token.VerificationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

import static com.example.aoms.user.mappers.UserMapper.mapDtoToEntity;
import static com.example.aoms.user.mappers.UserMapper.mapEntityToDto;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final VerificationTokenRepository tokenRepository;


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
    public String validateToken(String token) {
        VerificationToken verificationToken = tokenRepository.findByToken(token);
        if(verificationToken == null){
            return "Invalid verification token";
        }
        User user = verificationToken.getUser();
        if (verificationToken.getExpirationTime().isBefore(Instant.now())){
            return "Verification link already expired," +
                    " Please, click the link below to receive a new verification link";
        }
        user.setIsEnabled(true);
        userRepository.save(user);
        return "valid";
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
