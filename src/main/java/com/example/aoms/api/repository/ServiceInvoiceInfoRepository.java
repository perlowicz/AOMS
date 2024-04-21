package com.example.aoms.api.repository;

import com.example.aoms.api.entity.ServiceInvoiceInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceInvoiceInfoRepository extends JpaRepository<ServiceInvoiceInfo, Long> {
}
