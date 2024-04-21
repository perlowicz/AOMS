package com.example.aoms.api.mapper;

import com.example.aoms.api.mapper.AddressMapper;
import com.example.aoms.api.dto.CustomerDto;
import com.example.aoms.api.entity.Customer;

public class CustomerMapper {

    public static CustomerDto mapEntityToDto(Customer entity) {
        return CustomerDto.builder()
                .name(entity.getName())
                .NIP(entity.getNip())
                .address(AddressMapper.mapEntityToDto(entity.getAddress()))
                .build();
    }
}
