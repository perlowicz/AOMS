package com.example.aoms.api.service;

import com.example.aoms.api.data.nbpApi.NbpApiExchangeRateResponse;
import com.example.aoms.api.data.nbpApi.NbpApiSpecificCurrencyResponse;
import com.example.aoms.api.enums.NbpExchangeRateTable;

import java.time.LocalDate;
import java.util.List;

public interface NbpApiService {
    List<NbpApiExchangeRateResponse> getExchangeRatesFromTodayForTable(NbpExchangeRateTable table);
    List<NbpApiExchangeRateResponse> getExchangeRatesForTableOnSpecificDay(NbpExchangeRateTable table, LocalDate date);
    NbpApiSpecificCurrencyResponse getExchangeRateForCurrencyOnSpecificDay(NbpExchangeRateTable table, String code, LocalDate date);
}
