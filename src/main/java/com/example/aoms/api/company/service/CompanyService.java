package com.example.aoms.api.company.service;

import com.example.aoms.api.company.dto.CompanyDto;
import com.example.aoms.api.company.entity.Company;

public interface CompanyService {
    Company save(CompanyDto dto);
}
