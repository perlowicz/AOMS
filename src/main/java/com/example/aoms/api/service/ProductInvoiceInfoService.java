package com.example.aoms.api.service;

import com.example.aoms.api.entity.Invoice;
import com.example.aoms.api.dto.ProductInvoiceInfoDto;
import com.example.aoms.api.entity.ProductInvoiceInfo;

import java.util.List;

public interface ProductInvoiceInfoService {
    ProductInvoiceInfo save(ProductInvoiceInfoDto dto, Invoice invoiceEntity);
    void saveAll(List<ProductInvoiceInfoDto> dtoList, Invoice invoiceEntity);
}
