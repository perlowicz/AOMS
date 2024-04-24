package com.example.aoms.api.controller;

import com.example.aoms.api.enums.NbpExchangeRateTable;
import com.example.aoms.api.service.NbpApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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


    @GetMapping("/exchangeRates/{table}/{topCount}")
    public ResponseEntity<?> getTopCountExchangeRatesForTable(@PathVariable NbpExchangeRateTable table,
                                                              @PathVariable Integer topCount) {
        return ResponseEntity.ok(nbpApiService.getTopCountExchangeRatesForTable(table, topCount));
    }
}
