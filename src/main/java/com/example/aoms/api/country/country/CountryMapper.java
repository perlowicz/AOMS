package com.example.aoms.api.country.country;

import com.example.aoms.api.country.dto.CountryDto;
import com.example.aoms.api.country.entity.Country;

public class CountryMapper {

    public static CountryDto mapEntityToDto(Country entity) {
        return CountryDto.builder()
                .country(entity.getCountry())
                .build();
    }
}
