package com.example.aoms.api.customer.repository;

import com.example.aoms.api.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
