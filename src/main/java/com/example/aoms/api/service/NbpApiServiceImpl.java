package com.example.aoms.api.service;

import com.example.aoms.api.data.nbpApi.NbpApiExchangeRateResponse;
import com.example.aoms.api.data.nbpApi.NbpApiSpecificCurrencyResponse;
import com.example.aoms.api.enums.NbpExchangeRateTable;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;

import static com.example.aoms.api.utils.NbpApiEndpoints.*;

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
    public List<NbpApiExchangeRateResponse> getExchangeRatesForTableOnSpecificDay(NbpExchangeRateTable table, LocalDate date) {
        if (dateIsFromFuture(date)) {
            throw new IllegalArgumentException("Date cannot be from future");
        }
        logger.info("Making a call to NBP API for exchange rate for table: {} from date: {}", table, date);
        return webClient.get()
                .uri(buildUrlForExchangeRatesForTableOnSpecificDay(table, date))
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse ->
                        Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, buildErrorMessage(table, date))))
                .bodyToFlux(NbpApiExchangeRateResponse.class)
                .collectList()
                .block();
    }

    private static boolean dateIsFromFuture(LocalDate date) {
        return date.isAfter(LocalDate.now());
    }

    @Override
    public NbpApiSpecificCurrencyResponse getExchangeRateForCurrencyOnSpecificDay(NbpExchangeRateTable table, String code, LocalDate date) {
        logger.info("Making a call to NBP API for exchange rate for currency: {} from table: {} for date: {}", code, table, date);
        return webClient.get()
                .uri(buildUrlForCurrencyOnSpecificDay(table, code, date))
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse ->
                        Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, buildErrorMessage(table, code, date))))
                .bodyToMono(NbpApiSpecificCurrencyResponse.class)
                .block();
    }

    private static String buildUrlForExchangeRatesFromTodayForTable(NbpExchangeRateTable table) {
        return CURRENTLY_VALID_EXCHANGE_RATE_TABLE_ENDPOINT + table.getTable() + "?format=json";
    }

    private static String buildUrlForExchangeRatesForTableOnSpecificDay(NbpExchangeRateTable table, LocalDate date) {
        return CURRENTLY_VALID_EXCHANGE_RATE_TABLE_ENDPOINT + table.getTable() + "/" + date + "?format=json";
    }

    private static String buildUrlForCurrencyOnSpecificDay(NbpExchangeRateTable table, String code, LocalDate date) {
        return SPECIFIC_CURRENCY_ON_SPECIFIC_DAY_ENDPOINT + table.getTable() + "/" + code + "/" + date + "?format=json";
    }

    private static String buildErrorMessage(NbpExchangeRateTable table, LocalDate date) {
        return String.format("Exchange rate for table: %s for %s date could not be found in external API",
                table, date
        );
    }

    private static String buildErrorMessage(NbpExchangeRateTable table, String code, LocalDate date) {
        return String.format("Exchange rate for currency with code: %s from table: %s for %s date could not be found in external API",
                code, table, date
        );
    }
}
