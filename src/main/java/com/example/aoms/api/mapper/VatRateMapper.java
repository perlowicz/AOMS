package com.example.aoms.api.mapper;

import com.example.aoms.api.dto.VatRateDto;
import com.example.aoms.api.entity.VatRate;

public class VatRateMapper {

    public static VatRate mapDtoToEntity(VatRateDto dto) {
        VatRate entity = new VatRate();
        entity.setRate(dto.getRate());
        return entity;
    }

    public static VatRateDto mapEntityToDto(VatRate entity) {
        return VatRateDto.builder()
                .rate(entity.getRate())
                .build();
    }
}
