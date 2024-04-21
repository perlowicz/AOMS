package com.example.aoms.api.mapper;

import com.example.aoms.api.dto.CountryDto;
import com.example.aoms.api.entity.Country;

public class CountryMapper {

    public static CountryDto mapEntityToDto(Country entity) {
        return CountryDto.builder()
                .country(entity.getCountry())
                .build();
    }
}
