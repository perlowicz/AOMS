package com.example.aoms.api.company.service;

import com.example.aoms.api.address.entity.Address;
import com.example.aoms.api.address.service.AddressService;
import com.example.aoms.api.company.dto.CompanyDto;
import com.example.aoms.api.company.entity.Company;
import com.example.aoms.api.company.repository.CompanyRepository;
import com.example.aoms.api.user.entity.User;
import com.example.aoms.api.user.exception.UserNotFoundException;
import com.example.aoms.api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final AddressService addressService;
    private final UserService userService;

    @Override
    @SneakyThrows
    @Transactional
    public Company save(CompanyDto dto) {
        Address address = addressService.save(dto.getAddress());
        User user = userService
                .findUserByUsername(dto.getUserName())
                .orElseThrow(() -> new UserNotFoundException("User with username " + dto.getUserName() + " not found"));
        Company entity = mapDtoToEntity(dto, address, user);
        return companyRepository.save(entity);
    }

    private Company mapDtoToEntity(CompanyDto dto, Address address, User user) {
        Company entity = new Company();
        entity.setNip(dto.getNIP());
        entity.setName(dto.getName());
        entity.setAddress(address);
        entity.setUser(user);
        return entity;
    }
}
