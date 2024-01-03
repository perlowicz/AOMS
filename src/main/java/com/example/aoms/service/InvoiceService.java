package com.example.aoms.service;

import com.example.aoms.model.invoice.Invoice;
import com.example.aoms.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public List<Invoice> getAll() {
        return invoiceRepository.findAll();
    }

    public Invoice save(Invoice createdInvoice) {
        return invoiceRepository.save(createdInvoice);
    }
}
