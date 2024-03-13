package com.example.aoms.database.company.repository;

import com.example.aoms.database.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
