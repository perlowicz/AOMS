package com.example.aoms.controller;

import com.example.aoms.dto.ClientDto;
import com.example.aoms.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;


    @GetMapping("/clients")
    List<ClientDto> getAll() {
        return clientService.getClientDtoList();
    }

    @PostMapping("/client")
    ClientDto createClient(@RequestBody ClientDto createdClient) {
        return clientService.save(createdClient);
    }
}
