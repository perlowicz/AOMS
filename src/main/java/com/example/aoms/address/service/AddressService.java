package com.example.aoms.address.service;

import com.example.aoms.address.dto.AddressDto;
import com.example.aoms.address.entity.Address;

public interface AddressService {
    Address save(AddressDto dto);
}
