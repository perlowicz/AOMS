package com.example.aoms.api.address.service;

import com.example.aoms.api.address.dto.AddressDto;
import com.example.aoms.api.address.entity.Address;

public interface AddressService {
    Address save(AddressDto dto);
}
