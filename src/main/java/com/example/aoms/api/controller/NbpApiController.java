package com.example.aoms.api.controller;

import com.example.aoms.api.enums.NbpExchangeRateTable;
import com.example.aoms.api.service.NbpApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/nbp")
@RequiredArgsConstructor
public class NbpApiController {

    private final NbpApiService nbpApiService;


    @GetMapping("/exchangeRates/{table}")
    public ResponseEntity<?> getExchangeRateFromTodayForTable(@PathVariable NbpExchangeRateTable table) {
        return ResponseEntity.ok(nbpApiService.getExchangeRatesFromTodayForTable(table));
    }

    @GetMapping("/exchangeRates/{table}/{date}")
    public ResponseEntity<?> getTopCountExchangeRatesForTableOnSpecificDay(@PathVariable NbpExchangeRateTable table,
                                                                           @PathVariable LocalDate date) {
        return ResponseEntity.ok(nbpApiService.getExchangeRatesForTableOnSpecificDay(table, date));
    }

    //TODO For now endpoint not used on frontend
    @GetMapping("/exchangeRates/{table}/{code}/{date}")
    public ResponseEntity<?> getExchangeRateForCurrencyOnSpecificDay(@PathVariable NbpExchangeRateTable table,
                                                                     @PathVariable String code,
                                                                     @PathVariable LocalDate date) {
        return ResponseEntity.ok(nbpApiService.getExchangeRateForCurrencyOnSpecificDay(table, code, date));
    }
}
