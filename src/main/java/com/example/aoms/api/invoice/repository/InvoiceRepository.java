package com.example.aoms.api.invoice.repository;

import com.example.aoms.api.invoice.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
