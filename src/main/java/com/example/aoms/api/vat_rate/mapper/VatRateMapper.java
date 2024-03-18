package com.example.aoms.api.vat_rate.mapper;

import com.example.aoms.api.vat_rate.dto.VatRateDto;
import com.example.aoms.api.vat_rate.entity.VatRate;

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
