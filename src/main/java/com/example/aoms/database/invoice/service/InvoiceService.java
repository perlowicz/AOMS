package com.example.aoms.database.invoice.service;

import com.example.aoms.database.invoice.dto.InvoiceDto;

import java.util.List;

public interface InvoiceService {
    void save(InvoiceDto dto);
    List<InvoiceDto> findAllByUserId(Long userId);
}
