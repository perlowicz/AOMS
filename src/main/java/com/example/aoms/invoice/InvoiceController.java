package com.example.aoms.invoice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;


    @PostMapping
    ResponseEntity<?> saveInvoice(@RequestBody InvoiceFormDto dto) {
        Long savedEntityId = invoiceService.save(dto);
        return ResponseEntity
                .status(201)
                .body("Saved invoice with id: " + savedEntityId);
    }
}
