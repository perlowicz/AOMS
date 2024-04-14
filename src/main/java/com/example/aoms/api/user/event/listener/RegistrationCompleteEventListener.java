package com.example.aoms.api.user.event.listener;

import com.example.aoms.api.user.dto.UserDto;
import com.example.aoms.api.user.event.RegistrationCompleteEvent;
import com.example.aoms.api.user.service.UserService;
import com.example.aoms.api.user.dto.VerificationTokenDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    private static final int EXPIRATION_TIME = 15;

    private final UserService userService;
    private final JavaMailSender mailSender;

    private UserDto userDto;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        userDto = event.getUserDto();

        VerificationTokenDto dto = VerificationTokenDto.builder()
                .token(generateToken())
                .expirationTime(getTokenExpirationTime())
                .build();

        userService.saveUserVerificationToken(dto, userDto.getId());

        String url = event.getApplicationUrl() + "?token=" + dto.getToken();

        try {
            sendVerificationEmail(url);
        } catch (MessagingException | UnsupportedEncodingException e) {
            log.error("Cannot send email: {}", e.getMessage());
            throw new RuntimeException(e);
        }
        log.info("Click the link to verify your registration :  {}", url);
    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }

    public void sendVerificationEmail(String url) throws MessagingException, UnsupportedEncodingException {
        String subject = "Email Verification";
        String senderName = "Accounting Management System Service";
        String mailContent = "<p> Hi, " + userDto.getUserName() + ", </p>"+
                "<p>Thank you for registering with us."+
                " Please, follow the link below to complete your registration.</p>"+
                "<a href=\"" + url + "\">Verify your email to activate your account</a>"+
                "<p> Thank you, <br> Accounting Management System Service";
        MimeMessage message = mailSender.createMimeMessage();
        var messageHelper = new MimeMessageHelper(message);
        messageHelper.setFrom("bartek.perlinski1234@gmail.com", senderName);
        messageHelper.setTo(userDto.getEmail());
        messageHelper.setSubject(subject);
        messageHelper.setText(mailContent, true);
        mailSender.send(message);
    }

    private String generateToken() {
        return UUID.randomUUID().toString();
    }

    private Instant getTokenExpirationTime() {
        return Instant
                .now()
                .plus(EXPIRATION_TIME, ChronoUnit.MINUTES);
    }
}
