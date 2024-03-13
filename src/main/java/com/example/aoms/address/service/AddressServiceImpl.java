package com.example.aoms.address.service;

import com.example.aoms.address.repository.AddressRepository;
import com.example.aoms.address.dto.AddressDto;
import com.example.aoms.address.entity.Address;
import com.example.aoms.address.entity.Country;
import com.example.aoms.address.repository.CountryRepository;
import com.example.aoms.address.dto.CountryDto;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final CountryRepository countryRepository;

    @Override
    public AddressDto save(AddressDto dto) {
        Country country = findOrCreateCountry(dto.getCountry());
        Address entity = mapDtoToEntity(dto, country);
        Address savedEntity = addressRepository.save(entity);
        return mapEntityToDto(savedEntity);
    }

    @SneakyThrows
    private Country findOrCreateCountry(CountryDto dto) {
        return countryRepository
                .findCountryByCountry(dto.getCountry())
                .orElseGet(() -> {
                    Country entity = mapCountryDtoToEntity(dto);
                    return countryRepository.save(entity);
                });
    }

    private Country mapCountryDtoToEntity(CountryDto dto) {
        Country entity = new Country();
        entity.setCountry(dto.getCountry());
        return entity;
    }

    private Address mapDtoToEntity(AddressDto dto, Country country) {
        Address entity = new Address();
        entity.setCity(dto.getCity());
        entity.setStreetName(dto.getStreetName());
        entity.setStreetNumber(dto.getStreetNumber());
        entity.setCountry(country);
        return entity;
    }

    private AddressDto mapEntityToDto(Address entity) {
        return AddressDto.builder()
                .city(entity.getCity())
                .streetNumber(entity.getStreetNumber())
                .streetName(entity.getStreetName())
                .country(mapCountryEntityToDto(entity.getCountry()))
                .build();
    }

    private CountryDto mapCountryEntityToDto(Country country) {
        return CountryDto.builder()
                .country(country.getCountry())
                .build();
    }


}
