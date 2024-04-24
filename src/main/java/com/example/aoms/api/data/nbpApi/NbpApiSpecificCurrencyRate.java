package com.example.aoms.api.data.nbpApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NbpApiSpecificCurrencyRate {

    @JsonProperty("no")
    @Nonnull
    private String someNumber;

    @JsonProperty("effectiveDate")
    @Nonnull
    private LocalDate effectiveDate;

    @JsonProperty("mid")
    @Nonnull
    private Double mid;
}
