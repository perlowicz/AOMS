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
public class AddressRegistrationData {
    @JsonProperty("country")
    @Nonnull
    private String country;
    @JsonProperty("city")
    @Nonnull
    private String city;
    @JsonProperty("streetName")
    @Nonnull
    private String streetName;
    @JsonProperty("streetNumber")
    @Nonnull
    private String streetNumber;
}
