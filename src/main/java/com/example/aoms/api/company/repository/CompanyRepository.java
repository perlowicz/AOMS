package com.example.aoms.api.company.repository;

import com.example.aoms.api.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
