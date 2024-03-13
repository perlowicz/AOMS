package com.example.aoms.database.address.service;

import com.example.aoms.database.address.repository.AddressRepository;
import com.example.aoms.database.address.dto.AddressDto;
import com.example.aoms.database.address.entity.Address;
import com.example.aoms.database.address.entity.Country;
import com.example.aoms.database.address.repository.CountryRepository;
import com.example.aoms.database.address.dto.CountryDto;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final CountryRepository countryRepository;

    @Override
    @Transactional
    public Address save(AddressDto dto) {
        Country country = findOrCreateCountry(dto.getCountry());
        Address entity = mapDtoToEntity(dto, country);
        return addressRepository.save(entity);
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
                .id(entity.getId())
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
