package com.example.aoms.database.invoice_product.repository;

import com.example.aoms.database.invoice_product.entity.ProductInvoiceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInvoiceInfoRepository extends JpaRepository<ProductInvoiceInfo, Long> {
}
