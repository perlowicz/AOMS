package com.example.aoms.api.repository;

import com.example.aoms.api.entity.Company;
import com.example.aoms.api.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findAllByCompany(Company company);
}
