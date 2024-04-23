package com.example.aoms.api.controller;

import com.example.aoms.api.dto.CompanyDto;
import com.example.aoms.api.service.CompanyService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<?> getCompany(HttpServletRequest request) {
        final String jwt = request.getHeader("Authorization").substring(7);
        Optional<CompanyDto> foundCompany = companyService.findCompanyDtoByJwt(jwt);
        if (foundCompany.isPresent()) {
            return ResponseEntity.ok(foundCompany.get());
        }
        return ResponseEntity
                .badRequest()
                .build();
    }
}
