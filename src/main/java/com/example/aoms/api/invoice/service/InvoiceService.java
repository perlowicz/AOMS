package com.example.aoms.api.invoice.service;

import com.example.aoms.api.invoice.dto.InvoiceDto;
import com.example.aoms.api.invoice.entity.Invoice;

import java.util.List;

public interface InvoiceService {
    Invoice save(InvoiceDto dto);
    List<InvoiceDto> findAllByUserId(Long userId);
}
