package com.example.aoms.repository.client;

import com.example.aoms.model.client.ClientEvidenceSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientEvidenceSettingsRepository extends JpaRepository<ClientEvidenceSettings, Long> {
}
