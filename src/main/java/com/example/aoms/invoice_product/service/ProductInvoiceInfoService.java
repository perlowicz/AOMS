package com.example.aoms.invoice_product.service;

import com.example.aoms.invoice_product.dto.ProductInvoiceInfoDto;
import com.example.aoms.invoice_product.entity.ProductInvoiceInfo;

public interface ProductInvoiceInfoService {
    ProductInvoiceInfo save(ProductInvoiceInfoDto dto);
}
