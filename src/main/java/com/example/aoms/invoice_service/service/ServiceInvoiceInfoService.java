package com.example.aoms.invoice_service.service;

import com.example.aoms.invoice_service.dto.ServiceInvoiceInfoDto;
import com.example.aoms.invoice_service.entity.ServiceInvoiceInfo;

public interface ServiceInvoiceInfoService {
    ServiceInvoiceInfo save(ServiceInvoiceInfoDto dto);
}
