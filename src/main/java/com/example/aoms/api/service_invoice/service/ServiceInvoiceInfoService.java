package com.example.aoms.api.service_invoice.service;

import com.example.aoms.api.invoice.entity.Invoice;
import com.example.aoms.api.service_invoice.dto.ServiceInvoiceInfoDto;
import com.example.aoms.api.service_invoice.entity.ServiceInvoiceInfo;

import java.util.List;

public interface ServiceInvoiceInfoService {
    ServiceInvoiceInfo save(ServiceInvoiceInfoDto dto, Invoice invoice);
    void saveAll(List<ServiceInvoiceInfoDto> dtoList, Invoice invoice);
}
