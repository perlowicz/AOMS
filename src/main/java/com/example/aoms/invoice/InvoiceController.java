package com.example.aoms.invoice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;


    @GetMapping("/invoices/{companyId}")
    ResponseEntity<?> getInvoicesByCompany(@PathVariable Long companyId) {
        return ResponseEntity.ok(invoiceService.getInvoicesByCompany(companyId));
    }


    @PostMapping("/invoices")
    ResponseEntity<?> saveInvoice(@RequestBody InvoiceFormDto dto) {
        Long savedEntityId = invoiceService.save(dto);
        return ResponseEntity
                .status(201)
                .body("Saved invoice with id: " + savedEntityId);
    }
}
