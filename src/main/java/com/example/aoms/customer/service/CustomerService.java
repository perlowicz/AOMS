package com.example.aoms.customer.service;

import com.example.aoms.customer.dto.CustomerDto;
import com.example.aoms.customer.entity.Customer;

public interface CustomerService {
    Customer save(CustomerDto dto);
}
