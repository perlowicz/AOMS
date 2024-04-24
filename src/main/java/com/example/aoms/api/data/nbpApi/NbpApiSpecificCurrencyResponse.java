package com.example.aoms.api.data.nbpApi;

import com.example.aoms.api.enums.NbpExchangeRateTable;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NbpApiSpecificCurrencyResponse {

    @JsonProperty("table")
    @Nonnull
    private NbpExchangeRateTable table;

    @JsonProperty("currency")
    @Nonnull
    private String currency;

    @JsonProperty("code")
    @Nonnull
    private String code;

    @JsonProperty("rates")
    @Nonnull
    private List<NbpApiSpecificCurrencyRate> rateList;
}
