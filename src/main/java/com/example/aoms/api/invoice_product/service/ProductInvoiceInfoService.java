package com.example.aoms.api.invoice_product.service;

import com.example.aoms.api.invoice_product.dto.ProductInvoiceInfoDto;
import com.example.aoms.api.invoice_product.entity.ProductInvoiceInfo;

public interface ProductInvoiceInfoService {
    ProductInvoiceInfo save(ProductInvoiceInfoDto dto);
}
