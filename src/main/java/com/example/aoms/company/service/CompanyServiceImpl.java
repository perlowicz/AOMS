package com.example.aoms.company.service;

import com.example.aoms.address.dto.AddressDto;
import com.example.aoms.address.service.AddressService;
import com.example.aoms.company.dto.CompanyDto;
import com.example.aoms.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final AddressService addressService;

    @Override
    @Transactional
    public CompanyDto save(CompanyDto dto) {
        AddressDto save = addressService.save(dto.getAddressDto());
        return null;
    }
//
//    private Company mapDtoToEntity(CompanyDto dto) {
//
//    }
}
