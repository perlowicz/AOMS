package com.example.aoms.api.invoice_product.service;

import com.example.aoms.api.invoice.entity.Invoice;
import com.example.aoms.api.invoice_product.dto.ProductInvoiceInfoDto;
import com.example.aoms.api.invoice_product.entity.ProductInvoiceInfo;

import java.util.List;

public interface ProductInvoiceInfoService {
    ProductInvoiceInfo save(ProductInvoiceInfoDto dto, Invoice invoiceEntity);
    List<ProductInvoiceInfo> saveAll(List<ProductInvoiceInfoDto> dtoList, Invoice invoiceEntity);
}
