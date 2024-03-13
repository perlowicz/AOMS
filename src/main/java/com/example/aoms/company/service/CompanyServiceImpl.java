package com.example.aoms.company.service;

import com.example.aoms.address.entity.Address;
import com.example.aoms.address.service.AddressService;
import com.example.aoms.company.dto.CompanyDto;
import com.example.aoms.company.entity.Company;
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
    public Company save(CompanyDto dto) {
        Address addressEntity = addressService.save(dto.getAddress());
        Company entity = mapDtoToEntity(dto, addressEntity);
        return companyRepository.save(entity);
    }

    private Company mapDtoToEntity(CompanyDto dto, Address address) {
        Company entity = new Company();
        entity.setNip(dto.getNIP());
        entity.setName(dto.getName());
        entity.setAddress(address);
        return entity;
    }
}
