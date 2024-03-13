package com.example.aoms.database.customer.repository;

import com.example.aoms.database.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
