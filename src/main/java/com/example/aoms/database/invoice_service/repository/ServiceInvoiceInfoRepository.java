package com.example.aoms.database.invoice_service.repository;

import com.example.aoms.database.invoice_service.entity.ServiceInvoiceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceInvoiceInfoRepository extends JpaRepository<ServiceInvoiceInfo, Long> {
}
