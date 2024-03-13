package com.example.aoms.country;

public class CountryMapper {

    public static Country mapSaveDtoToEntity(CountrySaveDto dto) {
        Country entity = new Country();
        entity.setCountry(dto.getCountry());
        return entity;
    }

    public static CountrySaveDto mapEntityToDto(Country entity) {
        return CountrySaveDto.builder()
                .country(entity.getCountry())
                .build();
    }
}
