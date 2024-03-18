package com.example.aoms.api.product_invoice.repository;

import com.example.aoms.api.product_invoice.entity.ProductInvoiceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInvoiceInfoRepository extends JpaRepository<ProductInvoiceInfo, Long> {
}
