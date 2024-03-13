package com.example.aoms.country;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.aoms.country.CountryMapper.mapSaveDtoToEntity;

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
}
