package com.example.aoms.api.address.mapper;

import com.example.aoms.api.address.dto.AddressDto;
import com.example.aoms.api.address.entity.Address;
import com.example.aoms.api.country.country.CountryMapper;

public class AddressMapper {

    public static AddressDto mapEntityToDto(Address entity) {
        return AddressDto.builder()
                .city(entity.getCity())
                .streetName(entity.getStreetName())
                .streetNumber(entity.getStreetNumber())
                .country(CountryMapper.mapEntityToDto(entity.getCountry()))
                .build();
    }
}
