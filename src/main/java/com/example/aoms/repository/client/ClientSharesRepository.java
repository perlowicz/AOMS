package com.example.aoms.repository.client;

import com.example.aoms.model.client.ClientShares;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientSharesRepository extends JpaRepository<ClientShares, Long> {
}
