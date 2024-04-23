package com.example.aoms.api.service;

import com.example.aoms.api.dto.CompanyDto;
import com.example.aoms.api.entity.Company;
import com.example.aoms.api.entity.user.User;

import java.util.Optional;

public interface CompanyService {
    Company save(CompanyDto dto, User user);
    Optional<Company> findCompanyById(Long id);
    Optional<CompanyDto> findCompanyDtoByJwt(String jwt);
    Optional<Company> findCompanyByJwt(String jwt);
}
