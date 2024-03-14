package com.example.aoms.api.invoice.service;

import com.example.aoms.api.invoice.dto.InvoiceDto;

import java.util.List;

public interface InvoiceService {
    void save(InvoiceDto dto);
    List<InvoiceDto> findAllByUserId(Long userId);
}
