package com.example.aoms.api.unit_of_measure.service;

import com.example.aoms.api.unit_of_measure.dto.UnitOfMeasureDto;
import com.example.aoms.api.unit_of_measure.mapper.UnitOfMeasureMapper;
import com.example.aoms.api.unit_of_measure.repository.UnitOfMeasureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureRepository unitOfMeasureRepository;

    @Override
    public List<UnitOfMeasureDto> getAllUnits() {
        return unitOfMeasureRepository
                .findAll().stream()
                .map(UnitOfMeasureMapper::mapEntityToDto)
                .collect(Collectors.toList());
    }
}
