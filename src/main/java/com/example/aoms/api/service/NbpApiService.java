package com.example.aoms.api.service;

import com.example.aoms.api.data.nbpApi.NbpApiExchangeRateResponse;
import com.example.aoms.api.enums.NbpExchangeRateTable;

import java.util.List;

public interface NbpApiService {
    List<NbpApiExchangeRateResponse> getExchangeRatesFromTodayForTable(NbpExchangeRateTable table);
    List<NbpApiExchangeRateResponse> getTopCountExchangeRatesForTable(NbpExchangeRateTable table, Integer topCount);
}
