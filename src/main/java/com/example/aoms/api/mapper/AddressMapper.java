package com.example.aoms.api.mapper;

import com.example.aoms.api.data.userRegistration.AddressRegistrationData;
import com.example.aoms.api.dto.AddressDto;
import com.example.aoms.api.dto.CountryDto;
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

    public static AddressDto mapAddressRegistrationDataToDto(AddressRegistrationData addressRegistrationData) {
        return AddressDto.builder()
                .city(addressRegistrationData.getCity())
                .streetNumber(Integer.valueOf(addressRegistrationData.getStreetNumber()))
                .streetName(addressRegistrationData.getStreetName())
                .country(
                        CountryDto
                                .builder()
                                .country(addressRegistrationData.getCountry())
                                .build()
                )
                .build();
    }
}
