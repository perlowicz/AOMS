package com.example.aoms.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
