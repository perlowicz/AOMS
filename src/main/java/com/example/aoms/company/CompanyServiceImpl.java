package com.example.aoms.company;

import com.example.aoms.address.AddressDto;
import com.example.aoms.address.AddressService;
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
    }

    private Company mapDtoToEntity(CompanyDto dto) {

    }
}
