package com.example.aoms.api.mapper;

import com.example.aoms.api.dto.AddressDto;
import com.example.aoms.api.entity.Address;

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
