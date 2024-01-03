package com.example.aoms.repository.vat;

import com.example.aoms.model.client.VAT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VatRepository extends JpaRepository<VAT, Long> {
}
