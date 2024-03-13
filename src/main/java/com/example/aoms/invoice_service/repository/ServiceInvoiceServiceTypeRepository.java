package com.example.aoms.invoice_service.repository;

import com.example.aoms.invoice_service.entity.ServiceInvoiceServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceInvoiceServiceTypeRepository extends JpaRepository<ServiceInvoiceServiceType, Long> {
    Optional<ServiceInvoiceServiceType> findByType(String type);
}
