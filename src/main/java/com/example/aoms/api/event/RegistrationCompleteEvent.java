package com.example.aoms.api.event;

import com.example.aoms.api.dto.user.UserDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {
    private UserDto userDto;
    private String applicationUrl;

    public RegistrationCompleteEvent(UserDto userDto, String applicationUrl) {
        super(userDto);
        this.userDto = userDto;
        this.applicationUrl = applicationUrl;
    }
}
