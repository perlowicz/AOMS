package com.example.aoms.api.mapper;

import com.example.aoms.api.data.userRegistration.CompanyRegistrationData;
import com.example.aoms.api.dto.CompanyDto;
import com.example.aoms.api.entity.Address;
import com.example.aoms.api.entity.Company;
import com.example.aoms.api.entity.user.User;

import static com.example.aoms.api.mapper.AddressMapper.mapAddressRegistrationDataToDto;

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

    public static CompanyDto mapCompanyRegistrationDataToCompanyDto(CompanyRegistrationData companyRegistrationData) {
        return CompanyDto.builder()
                .name(companyRegistrationData.getName())
                .NIP(companyRegistrationData.getNIP())
                .address(mapAddressRegistrationDataToDto(companyRegistrationData.getAddressRegistrationData()))
                .build();
    }
}
