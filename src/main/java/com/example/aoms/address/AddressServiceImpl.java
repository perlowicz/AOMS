package com.example.aoms.address;

import com.example.aoms.country.Country;
import com.example.aoms.country.CountryMapper;
import com.example.aoms.country.CountrySaveDto;
import com.example.aoms.country.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final CountryService countryService;

    @Override
    public AddressDto save(AddressDto dto) {
        Address entity = mapDtoToEntity(dto);
        setCountryRelation(entity, dto);
        Address savedEntity = addressRepository.save(entity);
        return mapEntityToDto(savedEntity);
    }

    private AddressDto mapEntityToDto(Address entity) {
        return AddressDto.builder()
                .city(entity.getCity())
                .streetName(entity.getStreetName())
                .streetNumber(entity.getStreetNumber())
                .country(CountryMapper.mapEntityToDto(entity.getCountry()))
                .build();
    }

    private Address mapDtoToEntity(AddressDto dto) {
        Address entity = new Address();
        entity.setCity(dto.getCity());
        entity.setStreetName(dto.getStreetName());
        entity.setStreetNumber(dto.getStreetNumber());
        return entity;
    }

    private void setCountryRelation(Address entity, AddressDto dto) {
        CountrySaveDto countryDto = dto.getCountry();
        findCountry(countryDto.getCountry())
                .ifPresentOrElse(
                        entity::setCountry,
                        () -> {
                            Country savedCountry = countryService.save(countryDto);
                            entity.setCountry(savedCountry);
                        }
                );
    }

    private Optional<Country> findCountry(String country) {
        return countryService.findByCountry(country);
    }
}
