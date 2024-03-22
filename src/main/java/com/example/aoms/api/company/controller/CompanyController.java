package com.example.aoms.api.company.controller;

import com.example.aoms.api.company.dto.CompanyDto;
import com.example.aoms.api.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;


    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody CompanyDto dto) {
        companyService.save(dto);
        return ResponseEntity
                .status(201)
                .build();
    }
}
