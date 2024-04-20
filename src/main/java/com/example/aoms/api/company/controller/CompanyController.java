package com.example.aoms.api.company.controller;

import com.example.aoms.api.company.dto.CompanyDto;
import com.example.aoms.api.company.service.CompanyService;
import com.example.aoms.api.jwt_token.util.JwtUtil;
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
        Optional<CompanyDto> foundCompany = companyService.findCompanyByJwt(jwt);
        if (foundCompany.isPresent()) {
            return ResponseEntity.ok(foundCompany.get());
        }
        return ResponseEntity
                .notFound()
                .build();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody CompanyDto dto, HttpServletRequest request) {
        String jwt = JwtUtil.extractJwtFromRequest(request);
        companyService.save(dto, jwt);
        return ResponseEntity
                .status(201)
                .build();
    }
}
