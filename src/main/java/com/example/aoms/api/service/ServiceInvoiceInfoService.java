package com.example.aoms.api.service;

import com.example.aoms.api.entity.Invoice;
import com.example.aoms.api.dto.ServiceInvoiceInfoDto;
import com.example.aoms.api.entity.ServiceInvoiceInfo;

import java.util.List;

public interface ServiceInvoiceInfoService {
    ServiceInvoiceInfo save(ServiceInvoiceInfoDto dto, Invoice invoice);
    void saveAll(List<ServiceInvoiceInfoDto> dtoList, Invoice invoice);
}
