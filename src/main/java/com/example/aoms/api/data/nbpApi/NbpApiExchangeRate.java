package com.example.aoms.api.data.nbpApi;

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
public class NbpApiExchangeRate {
    @JsonProperty("currency")
    @Nonnull
    private String currency;

    @JsonProperty("code")
    @Nonnull
    private String code;

    @JsonProperty("mid")
    @Nonnull
    private Double mid;
}
