package com.example.aoms.invoice.service;

import com.example.aoms.invoice.dto.InvoiceDto;

import java.util.List;

public interface InvoiceService {
    void save(InvoiceDto dto);
    List<InvoiceDto> findAllByUserId(Long userId);
}
