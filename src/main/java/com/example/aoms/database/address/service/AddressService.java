package com.example.aoms.database.address.service;

import com.example.aoms.database.address.dto.AddressDto;
import com.example.aoms.database.address.entity.Address;

public interface AddressService {
    Address save(AddressDto dto);
}
