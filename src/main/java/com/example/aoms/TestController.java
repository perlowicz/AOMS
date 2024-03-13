package com.example.aoms;

import com.example.aoms.database.address.dto.AddressDto;
import com.example.aoms.database.address.service.AddressService;
import com.example.aoms.database.company.dto.CompanyDto;
import com.example.aoms.database.company.service.CompanyService;
import com.example.aoms.database.customer.dto.CustomerDto;
import com.example.aoms.database.customer.service.CustomerService;
import com.example.aoms.database.invoice.dto.InvoiceDto;
import com.example.aoms.database.invoice.service.InvoiceService;
import com.example.aoms.database.invoice_product.dto.ProductInvoiceInfoDto;
import com.example.aoms.database.invoice_product.service.ProductInvoiceInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final ProductInvoiceInfoService productInvoiceInfoService;
    private final AddressService addressService;
    private final CustomerService customerService;
    private final CompanyService companyService;
    private final InvoiceService invoiceService;


    @PostMapping("/product")
    ResponseEntity<?> saveProductType(@RequestBody ProductInvoiceInfoDto dto) {
        productInvoiceInfoService.save(dto);
        return ResponseEntity
                .status(201)
                .build();
    }

    @PostMapping("/address")
    ResponseEntity<?> saveAddress(@RequestBody AddressDto dto) {
        addressService.save(dto);
        return ResponseEntity
                .status(201)
                .build();
    }

    @PostMapping("/company")
    ResponseEntity<?> company(@RequestBody CompanyDto dto) {
        companyService.save(dto);
        return ResponseEntity
                .status(201)
                .build();
    }

    @PostMapping("/customer")
    ResponseEntity<?> customer(@RequestBody CustomerDto dto) {
        customerService.save(dto);
        return ResponseEntity
                .status(201)
                .build();
    }

    @PostMapping("/invoice")
    ResponseEntity<?> invoice(@RequestBody InvoiceDto dto) {
        invoiceService.save(dto);
        return ResponseEntity
                .status(201)
                .build();
    }
}
