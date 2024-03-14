package com.example.aoms.api.invoice_product.repository;

import com.example.aoms.api.invoice_product.entity.ProductInvoiceProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductInvoiceProductTypeRepository extends JpaRepository<ProductInvoiceProductType, Long> {
    Optional<ProductInvoiceProductType> findByType(String type);
}
