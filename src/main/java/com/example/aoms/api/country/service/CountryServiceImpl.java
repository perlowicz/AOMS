package com.example.aoms.api.country.service;

import com.example.aoms.api.country.dto.CountryDto;
import com.example.aoms.api.country.entity.Country;
import com.example.aoms.api.country.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;


    @Override
    public Optional<Country> findCountryByCountry(String country) {
        return countryRepository
                .findCountryByCountry(country);
    }

    @Override
    public List<CountryDto> getAll() {
        return countryRepository.findAll().stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Country save(CountryDto dto) {
        Country entity = mapDtoToEntity(dto);
        return countryRepository.save(entity);
    }

    private Country mapDtoToEntity(CountryDto dto) {
        Country entity = new Country();
        entity.setCountry(dto.getCountry());
        return entity;
    }

    private CountryDto mapEntityToDto(Country country) {
        return CountryDto.builder()
                .country(country.getCountry())
                .build();
    }
}
