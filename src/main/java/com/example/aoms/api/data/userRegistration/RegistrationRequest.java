package com.example.aoms.api.data.userRegistration;

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
public class RegistrationRequest {
    @JsonProperty("userData")
    @Nonnull
    private UserRegistrationData userRegistrationData;
    @JsonProperty("companyData")
    @Nonnull
    private CompanyRegistrationData companyRegistrationData;
}
