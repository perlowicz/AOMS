package com.example.aoms.api.company.mapper;

import com.example.aoms.api.address.entity.Address;
import com.example.aoms.api.address.mapper.AddressMapper;
import com.example.aoms.api.company.dto.CompanyDto;
import com.example.aoms.api.company.entity.Company;
import com.example.aoms.api.user.entity.User;

public class CompanyMapper {

    public static CompanyDto mapEntityToDto(Company entity) {
        return CompanyDto.builder()
                .name(entity.getName())
                .NIP(entity.getNip())
                .address(AddressMapper.mapEntityToDto(entity.getAddress()))
                .build();
    }

    public static Company mapDtoToEntity(CompanyDto dto, Address address, User user) {
        Company entity = new Company();
        entity.setNip(dto.getNIP());
        entity.setName(dto.getName());
        entity.setAddress(address);
        entity.setUser(user);
        return entity;
    }
}
