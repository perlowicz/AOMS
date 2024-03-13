package com.example.aoms;

import com.example.aoms.address.dto.AddressDto;
import com.example.aoms.address.service.AddressService;
import com.example.aoms.company.dto.CompanyDto;
import com.example.aoms.company.service.CompanyService;
import com.example.aoms.invoice.CustomerDto;
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
    private final AddressService addressService;
//    private final CustomerService customerService;
    private final CompanyService companyService;


    @PostMapping("/product")
    ResponseEntity<?> saveProductType(@RequestBody ProductInvoiceInfoDto dto) {
        ProductInvoiceInfoDto savedProductType = productInvoiceInfoService.save(dto);
        return ResponseEntity
                .status(201)
                .body(savedProductType);
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


}
