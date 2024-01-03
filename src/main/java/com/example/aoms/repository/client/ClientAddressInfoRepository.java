package com.example.aoms.repository.client;

import com.example.aoms.model.client.ClientAddressInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientAddressInfoRepository extends JpaRepository<ClientAddressInfo, Long> {
}
