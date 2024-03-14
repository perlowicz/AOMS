package com.example.aoms.api.country.controller;

import com.example.aoms.api.country.dto.CountryDto;
import com.example.aoms.api.country.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;


    @GetMapping("/all")
    ResponseEntity<?> getAll() {
        List<CountryDto> countriesDtos = countryService.getAll();
        return ResponseEntity.ok(countriesDtos);
    }

    @PostMapping("/save")
    ResponseEntity<?> saveCountry(@RequestBody CountryDto dto) {
        countryService.save(dto);
        return ResponseEntity
                .status(201)
                .build();
    }
}
