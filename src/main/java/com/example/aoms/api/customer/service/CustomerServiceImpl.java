package com.example.aoms.api.customer.service;

import com.example.aoms.api.address.entity.Address;
import com.example.aoms.api.address.service.AddressService;
import com.example.aoms.api.customer.dto.CustomerDto;
import com.example.aoms.api.customer.entity.Customer;
import com.example.aoms.api.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final AddressService addressService;

    @Override
    @Transactional
    public Customer save(CustomerDto dto) {
        Address addressEntity = addressService.save(dto.getAddress());
        Customer entity = mapDtoToEntity(dto, addressEntity);
        return customerRepository.save(entity);
    }

    private Customer mapDtoToEntity(CustomerDto dto, Address address) {
        Customer entity = new Customer();
        entity.setName(dto.getName());
        entity.setNip(dto.getNIP());
        entity.setAddress(address);
        return entity;
    }
}
