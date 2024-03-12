package com.example.aoms.country;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public Country save(CountrySaveDto dto) {
        Country entity = mapSaveDtoToEntity(dto);
        return countryRepository.save(entity);
    }

    @Override
    public Optional<Country> findByCountry(String country) {
        return countryRepository
                .findCountryByCountry(country);
    }

    private Country mapSaveDtoToEntity(CountrySaveDto dto) {
        Country entity = new Country();
        entity.setCountry(dto.getCountry());
        return entity;
    }

    private CountryDto mapEntityToDto(Country entity) {
        return CountryDto.builder()
                .id(entity.getId())
                .country(entity.getCountry())
                .build();
    }
}
