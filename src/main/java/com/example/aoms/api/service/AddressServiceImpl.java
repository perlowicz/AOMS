package com.example.aoms.api.service;

import com.example.aoms.api.repository.AddressRepository;
import com.example.aoms.api.dto.AddressDto;
import com.example.aoms.api.entity.Address;
import com.example.aoms.api.entity.Country;
import com.example.aoms.api.dto.CountryDto;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final CountryService countryService;

    @Override
    @Transactional
    public Address save(AddressDto dto) {
        Country country = findOrCreateCountry(dto.getCountry());
        Address entity = mapDtoToEntity(dto, country);
        return addressRepository.save(entity);
    }

    @SneakyThrows
    private Country findOrCreateCountry(CountryDto dto) {
        return countryService
                .findCountryByCountry(dto.getCountry())
                .orElseGet(() -> countryService.save(dto));
    }

    private Address mapDtoToEntity(AddressDto dto, Country country) {
        Address entity = new Address();
        entity.setCity(dto.getCity());
        entity.setStreetName(dto.getStreetName());
        entity.setStreetNumber(dto.getStreetNumber());
        entity.setCountry(country);
        return entity;
    }

}
