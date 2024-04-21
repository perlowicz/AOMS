package com.example.aoms.api.service;

import com.example.aoms.api.dto.CustomerDto;
import com.example.aoms.api.entity.Customer;

public interface CustomerService {
    Customer save(CustomerDto dto);
}
