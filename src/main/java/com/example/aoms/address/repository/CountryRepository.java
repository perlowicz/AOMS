package com.example.aoms.address.repository;

import com.example.aoms.address.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findCountryByCountry(String country);
}
