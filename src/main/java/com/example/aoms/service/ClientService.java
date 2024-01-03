package com.example.aoms.service;

import com.example.aoms.model.client.Client;
import com.example.aoms.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Client save(Client createdClient) {
        return clientRepository.save(createdClient);
    }
}
