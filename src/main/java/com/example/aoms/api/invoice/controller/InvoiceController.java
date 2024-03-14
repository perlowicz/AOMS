package com.example.aoms.api.invoice.controller;

import com.example.aoms.api.invoice.dto.InvoiceDto;
import com.example.aoms.api.invoice.service.SavingInvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/invoice")
public class InvoiceController {

    private final SavingInvoiceService savingInvoiceService;

    @PostMapping("/save")
    ResponseEntity<?> saveInvoice(@RequestBody InvoiceDto dto) {
        savingInvoiceService.save(dto);
        return ResponseEntity
                .status(201)
                .body("Invoice created properly");
    }

    @GetMapping("/user/{userId}")
    ResponseEntity<?> getAllInvoicesByUserId(@PathVariable Long userId) {
//        List<InvoiceDto> invoiceDtos = invoiceService.findAllByUserId(userId);
        return ResponseEntity
                .ok(null);
    }
}
