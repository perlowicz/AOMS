package com.example.aoms.api.service;

import com.example.aoms.api.dto.InvoiceDto;
import com.example.aoms.api.entity.Invoice;

import java.util.List;

public interface InvoiceService {
    Invoice save(InvoiceDto dto, String jwt);
    List<InvoiceDto> getAllForUserWithJwt(String jwt);
}
