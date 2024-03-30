package com.example.aoms.api.invoice.service;

import com.example.aoms.api.invoice.dto.InvoiceDto;

public interface SavingInvoiceService {
    void save(InvoiceDto dto, String jwt);
}
