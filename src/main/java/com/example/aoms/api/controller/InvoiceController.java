package com.example.aoms.api.controller;

import com.example.aoms.api.dto.InvoiceDto;
import com.example.aoms.api.service.InvoiceService;
import com.example.aoms.api.service.SavingInvoiceService;
import com.example.aoms.api.jwt_token.util.JwtUtil;
import com.example.aoms.api.dto.UnitOfMeasureDto;
import com.example.aoms.api.service.UnitOfMeasureService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final SavingInvoiceService savingInvoiceService;
    private final UnitOfMeasureService unitOfMeasureService;

    @PostMapping("/save")
    ResponseEntity<?> saveInvoice(@RequestBody InvoiceDto dto, HttpServletRequest request) {
        final String jwt = JwtUtil.extractJwtFromRequest(request);
        savingInvoiceService.save(dto, jwt);
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

    @GetMapping("/all")
    ResponseEntity<?> getAll(HttpServletRequest request) {
        final String jwt = JwtUtil.extractJwtFromRequest(request);
        return ResponseEntity.ok(invoiceService.getAllForUserWithJwt(jwt));
    }
}
