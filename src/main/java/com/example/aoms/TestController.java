package com.example.aoms;

import com.example.aoms.invoice_product.dto.ProductInvoiceInfoDto;
import com.example.aoms.invoice_product.service.ProductInvoiceInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final ProductInvoiceInfoService productInvoiceInfoService;


    @PostMapping("/product")
    ResponseEntity<?> saveProductType(@RequestBody ProductInvoiceInfoDto dto) {
        ProductInvoiceInfoDto savedProductType = productInvoiceInfoService.save(dto);
        return ResponseEntity
                .status(201)
                .body(savedProductType);
    }
}
