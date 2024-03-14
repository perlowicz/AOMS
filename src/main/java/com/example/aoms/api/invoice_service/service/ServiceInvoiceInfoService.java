package com.example.aoms.api.invoice_service.service;

import com.example.aoms.api.invoice_service.dto.ServiceInvoiceInfoDto;
import com.example.aoms.api.invoice_service.entity.ServiceInvoiceInfo;

public interface ServiceInvoiceInfoService {
    ServiceInvoiceInfo save(ServiceInvoiceInfoDto dto);
}
