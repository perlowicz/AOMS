package com.example.aoms.api.unit_of_measure.repository;

import com.example.aoms.api.unit_of_measure.entity.UnitOfMeasure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends JpaRepository<UnitOfMeasure, Long> {
    Optional<UnitOfMeasure> findUnitOfMeasureByUnit(String unit);
}
