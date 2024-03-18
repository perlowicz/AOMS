package com.example.aoms.api.invoice.controller;

import com.example.aoms.api.invoice.dto.InvoiceDto;
import com.example.aoms.api.invoice.service.SavingInvoiceService;
import com.example.aoms.api.unit_of_measure.dto.UnitOfMeasureDto;
import com.example.aoms.api.unit_of_measure.entity.UnitOfMeasure;
import com.example.aoms.api.unit_of_measure.service.UnitOfMeasureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/invoice")
public class InvoiceController {

    private final SavingInvoiceService savingInvoiceService;
    private final UnitOfMeasureService unitOfMeasureService;

    @PostMapping("/save")
    ResponseEntity<?> saveInvoice(@RequestBody InvoiceDto dto) {
        savingInvoiceService.save(dto);
        return ResponseEntity
                .status(201)
                .body("Invoice created properly");
    }

    @GetMapping("/units")
    ResponseEntity<?> getAllUnits() {
        List<UnitOfMeasureDto> allUnits = unitOfMeasureService.getAllUnits();
        return ResponseEntity
                .ok(allUnits);
    }

    @GetMapping("/user/{userId}")
    ResponseEntity<?> getAllInvoicesByUserId(@PathVariable Long userId) {
//        List<InvoiceDto> invoiceDtos = invoiceService.findAllByUserId(userId);
        return ResponseEntity
                .ok(null);
    }
}
