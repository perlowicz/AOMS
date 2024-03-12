package com.example.aoms.address;

import com.example.aoms.country.Country;
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
    public void save(AddressDto dto) {
        Address entity = mapDtoToEntity(dto);
        setCountryRelation(entity, dto);
        addressRepository.save(entity);
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
