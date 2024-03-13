package com.example.aoms.database.address.repository;

import com.example.aoms.database.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
