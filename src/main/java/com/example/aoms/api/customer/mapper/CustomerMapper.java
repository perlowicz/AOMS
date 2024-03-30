package com.example.aoms.api.customer.mapper;

import com.example.aoms.api.address.mapper.AddressMapper;
import com.example.aoms.api.customer.dto.CustomerDto;
import com.example.aoms.api.customer.entity.Customer;

public class CustomerMapper {

    public static CustomerDto mapEntityToDto(Customer entity) {
        return CustomerDto.builder()
                .name(entity.getName())
                .NIP(entity.getNip())
                .address(AddressMapper.mapEntityToDto(entity.getAddress()))
                .build();
    }
}
