package com.example.aoms;

import com.example.aoms.api.dto.AddressDto;
import com.example.aoms.api.service.AddressService;
import com.example.aoms.api.dto.CompanyDto;
import com.example.aoms.api.service.CompanyService;
import com.example.aoms.api.dto.CustomerDto;
import com.example.aoms.api.service.CustomerService;
import com.example.aoms.api.dto.InvoiceDto;
import com.example.aoms.api.service.InvoiceService;
import com.example.aoms.api.jwt_token.util.JwtUtil;
import com.example.aoms.api.dto.ProductInvoiceInfoDto;
import com.example.aoms.api.service.ProductInvoiceInfoService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    ResponseEntity<?> company(@RequestBody CompanyDto dto, HttpServletRequest request) {
        String jwt = request.getHeader("Authorization").substring(7);
        companyService.save(dto, jwt);
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
    ResponseEntity<?> invoice(@RequestBody InvoiceDto dto, HttpServletRequest request) {
        String jwt = JwtUtil.extractJwtFromRequest(request);
        invoiceService.save(dto, jwt);
        return ResponseEntity
                .status(201)
                .build();
    }

    @GetMapping("/secret")
    ResponseEntity<?> secret() {
        return ResponseEntity.ok("Authenticated properly!");
    }

    @GetMapping("/oauth2")
    ResponseEntity<?> oauth2() {
        return ResponseEntity.ok("Authenticated properly with OAuth2!");
    }
}
