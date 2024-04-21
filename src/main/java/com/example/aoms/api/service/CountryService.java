package com.example.aoms.api.service;

import com.example.aoms.api.dto.CountryDto;
import com.example.aoms.api.entity.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    Country save(CountryDto dto);
    Optional<Country> findCountryByCountry(String country);
    List<CountryDto> getAll();
}
