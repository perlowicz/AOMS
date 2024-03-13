package com.example.aoms.database.company.service;

import com.example.aoms.database.company.dto.CompanyDto;
import com.example.aoms.database.company.entity.Company;

public interface CompanyService {
    Company save(CompanyDto dto);
}
