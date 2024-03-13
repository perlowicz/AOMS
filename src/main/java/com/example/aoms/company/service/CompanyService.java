package com.example.aoms.company.service;

import com.example.aoms.company.dto.CompanyDto;
import com.example.aoms.company.entity.Company;

public interface CompanyService {
    Company save(CompanyDto dto);
}
