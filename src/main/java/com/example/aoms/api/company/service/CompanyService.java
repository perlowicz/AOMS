package com.example.aoms.api.company.service;

import com.example.aoms.api.company.dto.CompanyDto;
import com.example.aoms.api.company.entity.Company;

import java.util.Optional;

public interface CompanyService {
    Company save(CompanyDto dto, String jwt);
    Optional<Company> findCompanyById(Long id);
    Optional<CompanyDto> findCompanyByJwt(String jwt);
}
