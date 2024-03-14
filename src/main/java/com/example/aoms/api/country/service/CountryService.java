package com.example.aoms.api.country.service;

import com.example.aoms.api.country.dto.CountryDto;
import com.example.aoms.api.country.entity.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    Country save(CountryDto dto);
    Optional<Country> findCountryByCountry(String country);
    List<CountryDto> getAll();
}
