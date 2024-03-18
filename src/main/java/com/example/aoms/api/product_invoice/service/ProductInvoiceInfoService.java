package com.example.aoms.api.product_invoice.service;

import com.example.aoms.api.invoice.entity.Invoice;
import com.example.aoms.api.product_invoice.dto.ProductInvoiceInfoDto;
import com.example.aoms.api.product_invoice.entity.ProductInvoiceInfo;

import java.util.List;

public interface ProductInvoiceInfoService {
    ProductInvoiceInfo save(ProductInvoiceInfoDto dto, Invoice invoiceEntity);
    void saveAll(List<ProductInvoiceInfoDto> dtoList, Invoice invoiceEntity);
}
