package com.example.aoms.controller;

import com.example.aoms.model.Invoice;
import com.example.aoms.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    private InvoiceRepository invoiceRepository;


    @GetMapping("/invoices")
    List<Invoice> getAll() {
        return invoiceRepository.findAll();
    }


    @PostMapping("/invoice")
    Invoice createInvoice(@RequestBody Invoice createdInvoice) {
        return invoiceRepository.save(createdInvoice);
    }
}
