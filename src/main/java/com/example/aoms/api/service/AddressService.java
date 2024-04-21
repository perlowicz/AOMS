package com.example.aoms.api.service;

import com.example.aoms.api.dto.AddressDto;
import com.example.aoms.api.entity.Address;

public interface AddressService {
    Address save(AddressDto dto);
}
