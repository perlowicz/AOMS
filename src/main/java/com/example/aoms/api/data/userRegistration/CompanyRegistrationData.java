package com.example.aoms.api.data.userRegistration;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
//@AllArgsConstructor
@NoArgsConstructor
public class CompanyRegistrationData {
    @JsonProperty("name")
    @Nonnull
    private String name;
    @JsonProperty("NIP")
    @Nonnull
    private String NIP;
    @JsonProperty("address")
    @Nonnull
    private AddressRegistrationData addressRegistrationData;
}
