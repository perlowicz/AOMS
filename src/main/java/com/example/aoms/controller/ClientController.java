package com.example.aoms.controller;

import com.example.aoms.model.client.Client;
import com.example.aoms.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;


    @GetMapping("/invoices")
    List<Client> getAll() {
        return clientService.getAll();
    }

    @PostMapping("/invoice")
    Client createInvoice(@RequestBody Client createdClient) {
        return clientService.save(createdClient);
    }
}
