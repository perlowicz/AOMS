package com.example.aoms.api.repository;

import com.example.aoms.api.entity.ProductInvoiceInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInvoiceInfoRepository extends JpaRepository<ProductInvoiceInfo, Long> {
}
