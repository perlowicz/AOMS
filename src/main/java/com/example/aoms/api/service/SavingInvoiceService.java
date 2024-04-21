package com.example.aoms.api.service;

import com.example.aoms.api.dto.InvoiceDto;

public interface SavingInvoiceService {
    void save(InvoiceDto dto, String jwt);
}
