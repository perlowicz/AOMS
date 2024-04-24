package com.example.aoms.api.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NbpExchangeRateTable {
    A("A"),
    B("B"),
    C("C");

    private final String table;
}
