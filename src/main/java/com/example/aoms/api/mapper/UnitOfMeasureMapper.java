package com.example.aoms.api.mapper;

import com.example.aoms.api.dto.UnitOfMeasureDto;
import com.example.aoms.api.entity.UnitOfMeasure;

public class UnitOfMeasureMapper {

    public static UnitOfMeasure mapDtoToEntity(UnitOfMeasureDto dto) {
        UnitOfMeasure entity = new UnitOfMeasure();
        entity.setUnit(dto.getUnit());
        return entity;
    }

    public static UnitOfMeasureDto mapEntityToDto(UnitOfMeasure entity) {
        return UnitOfMeasureDto.builder()
                .unit(entity.getUnit())
                .build();
    }
}
