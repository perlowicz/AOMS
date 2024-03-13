package com.example.aoms.database.invoice_service.service;

import com.example.aoms.database.invoice_service.dto.ServiceInvoiceInfoDto;
import com.example.aoms.database.invoice_service.entity.ServiceInvoiceInfo;

public interface ServiceInvoiceInfoService {
    ServiceInvoiceInfo save(ServiceInvoiceInfoDto dto);
}
