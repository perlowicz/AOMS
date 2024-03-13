package com.example.aoms.database.invoice.repository;

import com.example.aoms.database.invoice.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
