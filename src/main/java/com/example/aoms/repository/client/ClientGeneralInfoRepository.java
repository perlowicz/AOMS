package com.example.aoms.repository.client;

import com.example.aoms.model.client.ClientGeneralInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientGeneralInfoRepository extends JpaRepository<ClientGeneralInfo, Long> {
}
