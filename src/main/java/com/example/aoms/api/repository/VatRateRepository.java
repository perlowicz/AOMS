package com.example.aoms.api.repository;

import com.example.aoms.api.entity.VatRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface VatRateRepository extends JpaRepository<VatRate, Long> {
    Optional<VatRate> findVatRateByRate(BigDecimal rate);
}
