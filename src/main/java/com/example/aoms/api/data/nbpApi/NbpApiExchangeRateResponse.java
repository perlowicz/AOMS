package com.example.aoms.api.data.nbpApi;

import com.example.aoms.api.enums.NbpExchangeRateTable;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NbpApiExchangeRateResponse {
    @JsonProperty("table")
    @Nonnull
    private NbpExchangeRateTable table;

    @JsonProperty("no")
    @Nonnull
    //TODO figure out what no means in response from NBP API
    private String someNumber;

    @JsonProperty("effectiveDate")
    @Nonnull
    private LocalDate effectiveDate;

    @JsonProperty("rates")
    @Nonnull
    private List<NbpApiExchangeRate> ratesList;
}
