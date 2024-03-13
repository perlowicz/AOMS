package com.example.aoms.database.invoice.controller;

import com.example.aoms.database.invoice.dto.InvoiceDto;
import com.example.aoms.database.invoice.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @PostMapping("/addInvoice")
    ResponseEntity<?> addInvoice(@RequestBody InvoiceDto dto) {
        invoiceService.save(dto);
        return ResponseEntity
                .status(201)
                .body("Invoice created properly");
    }

    @GetMapping("/user/{userId}")
    ResponseEntity<?> getAllInvoicesByUserId(@PathVariable Long userId) {
        List<InvoiceDto> invoiceDtos = invoiceService.findAllByUserId(userId);
        return ResponseEntity
                .ok(invoiceDtos);
    }
}
