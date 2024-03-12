package com.example.aoms.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserFormDto {
    @JsonProperty("username")
    @Nonnull
    private String userName;
    @JsonProperty("email")
    @Nonnull
    private String email;
    @JsonProperty("password")
    @Nonnull
    private String password;
}
