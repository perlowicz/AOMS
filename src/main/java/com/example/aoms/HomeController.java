package com.example.aoms;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @GetMapping
    public ResponseEntity<?> helloWorld() {
        return ResponseEntity.ok("Hello world!");
    }
}
