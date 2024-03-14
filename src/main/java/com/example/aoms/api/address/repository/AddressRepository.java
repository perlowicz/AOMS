package com.example.aoms.api.address.repository;

import com.example.aoms.api.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
