package com.example.aoms.api.service;

import com.example.aoms.api.data.nbpApi.NbpApiExchangeRateResponse;
import com.example.aoms.api.enums.NbpExchangeRateTable;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static com.example.aoms.api.utils.NbpApiEndpoints.CURRENTLY_VALID_EXCHANGE_RATE_TABLE_ENDPOINT;
import static com.example.aoms.api.utils.NbpApiEndpoints.NBP_API_BASE_URL;

@Service
@RequiredArgsConstructor
public class NbpApiServiceImpl implements NbpApiService {

    private final WebClient webClient = WebClient.create(NBP_API_BASE_URL);

    private static final Logger logger = LoggerFactory.getLogger(NbpApiServiceImpl.class);

    @Override
    public List<NbpApiExchangeRateResponse> getExchangeRatesFromTodayForTable(NbpExchangeRateTable table) {
        logger.info("Making a call to NBP API for exchange rate from today for table: {}", table);
        return webClient.get()
                .uri(buildUrlForExchangeRatesFromTodayForTable(table))
                .retrieve()
                .bodyToFlux(NbpApiExchangeRateResponse.class)
                .collectList()
                .block();
    }

    @Override
    public List<NbpApiExchangeRateResponse> getTopCountExchangeRatesForTable(NbpExchangeRateTable table, Integer topCount) {
        logger.info("Making a call to NBP API for exchange rate from last {} days for table: {}", topCount, table);
        return webClient.get()
                .uri(buildUrlForLastTopCountTableRates(table, topCount))
                .retrieve()
                .bodyToFlux(NbpApiExchangeRateResponse.class)
                .collectList()
                .block();
    }

    private static String buildUrlForExchangeRatesFromTodayForTable(NbpExchangeRateTable table) {
        return CURRENTLY_VALID_EXCHANGE_RATE_TABLE_ENDPOINT + table.getTable() + "?format=json";
    }

    private static String buildUrlForLastTopCountTableRates(NbpExchangeRateTable table, Integer topCount) {
        return CURRENTLY_VALID_EXCHANGE_RATE_TABLE_ENDPOINT + table.getTable() + "/last/" + topCount + "?format=json";
    }
}
