package com.example.aoms.api.customer.service;

import com.example.aoms.api.customer.dto.CustomerDto;
import com.example.aoms.api.customer.entity.Customer;

public interface CustomerService {
    Customer save(CustomerDto dto);
}
