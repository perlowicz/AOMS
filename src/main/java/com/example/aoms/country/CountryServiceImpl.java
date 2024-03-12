package com.example.aoms.country;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public void save(CountryDto dto) {
        Country entity = mapDtoToEntity(dto);
        countryRepository.save(entity);
    }

    private Country mapDtoToEntity(CountryDto dto) {
        Country entity = new Country();
        entity.setCountry(dto.getCountry());
        return entity;
    }
}
