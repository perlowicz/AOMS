package com.example.aoms.database.customer.service;

import com.example.aoms.database.customer.dto.CustomerDto;
import com.example.aoms.database.customer.entity.Customer;

public interface CustomerService {
    Customer save(CustomerDto dto);
}
