package com.example.aoms.service;

import com.example.aoms.dto.ClientDto;
import com.example.aoms.model.client.ClientGeneralInfo;
import com.example.aoms.repository.client.ClientAddressInfoRepository;
import com.example.aoms.repository.client.ClientGeneralInfoRepository;
import com.example.aoms.repository.client.ClientRepository;
import com.example.aoms.repository.client.ClientSharesRepository;
import com.example.aoms.repository.vat.VatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientAddressInfoRepository clientAddressInfoRepository;
    private final ClientGeneralInfoRepository clientGeneralInfoRepository;
    private final ClientSharesRepository clientSharesRepository;
    private final VatRepository vatRepository;

    public List<ClientDto> getClientDtoList() {
        List<ClientGeneralInfo> entities = clientGeneralInfoRepository.findAll();
        return mapEntityListToDtoList(entities);
    }

    public ClientDto save(ClientDto createdClient) {
        clientRepository.save()
    }

    private List<ClientDto> mapEntityListToDtoList(List<ClientGeneralInfo> entities) {
        return entities.stream()
                .map(entity -> ClientDto.builder()
                        .fullName(entity.getFullName())
                        .NIP(entity.getNIP())
                        .build())
                .collect(Collectors.toList());
    }
}
