package com.example.aoms.country;

import java.util.Optional;

public interface CountryService {
    Country save(CountrySaveDto dto);
    Optional<Country> findByCountry(String country);
}
