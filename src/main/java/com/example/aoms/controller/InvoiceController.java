package com.example.aoms.controller;

import com.example.aoms.model.invoice.Invoice;
import com.example.aoms.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;


    @GetMapping("/invoices")
    List<Invoice> getAll() {
        return invoiceService.getAll();
    }


    @PostMapping("/invoice")
    Invoice createInvoice(@RequestBody Invoice createdInvoice) {
        return invoiceService.save(createdInvoice);
    }
}
