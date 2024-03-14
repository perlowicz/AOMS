package com.example.aoms.api.invoice_service.service;

import com.example.aoms.api.invoice.entity.Invoice;
import com.example.aoms.api.invoice_service.dto.ServiceInvoiceInfoDto;
import com.example.aoms.api.invoice_service.entity.ServiceInvoiceInfo;

import java.util.List;

public interface ServiceInvoiceInfoService {
    ServiceInvoiceInfo save(ServiceInvoiceInfoDto dto, Invoice invoice);
    List<ServiceInvoiceInfo> saveAll(List<ServiceInvoiceInfoDto> dtoList, Invoice invoice);
}
