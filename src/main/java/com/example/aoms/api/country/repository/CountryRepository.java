package com.example.aoms.api.country.repository;

import com.example.aoms.api.country.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findCountryByCountry(String country);
}
