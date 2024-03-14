package com.example.aoms.api.invoice_service.service;

import com.example.aoms.api.invoice.entity.Invoice;
import com.example.aoms.api.invoice_service.dto.ServiceInvoiceInfoDto;
import com.example.aoms.api.invoice_service.dto.ServiceInvoiceServiceTypeDto;
import com.example.aoms.api.invoice_service.entity.ServiceInvoiceInfo;
import com.example.aoms.api.invoice_service.entity.ServiceInvoiceServiceType;
import com.example.aoms.api.invoice_service.repository.ServiceInvoiceInfoRepository;
import com.example.aoms.api.invoice_service.repository.ServiceInvoiceServiceTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceInvoiceInfoServiceImpl implements ServiceInvoiceInfoService {

    private final ServiceInvoiceInfoRepository serviceInvoiceInfoRepository;
    private final ServiceInvoiceServiceTypeRepository serviceInvoiceServiceTypeRepository;


    @Override
    @Transactional
    public ServiceInvoiceInfo save(ServiceInvoiceInfoDto dto, Invoice invoice) {
        ServiceInvoiceServiceType serviceType = findOrCreateServiceType(dto.getServiceType());
        ServiceInvoiceInfo entity = mapDtoToEntity(dto, serviceType, invoice);
        return serviceInvoiceInfoRepository.save(entity);
    }

    @Override
    public List<ServiceInvoiceInfo> saveAll(List<ServiceInvoiceInfoDto> dtoList, Invoice invoice) {
        List<ServiceInvoiceInfo> entities = dtoList.stream()
                .map(dto -> {
                    ServiceInvoiceServiceType serviceType = findOrCreateServiceType(dto.getServiceType());
                    return mapDtoToEntity(dto, serviceType, invoice);
                })
                .collect(Collectors.toList());
        return serviceInvoiceInfoRepository.saveAll(entities);
    }

    @SneakyThrows
    private ServiceInvoiceServiceType findOrCreateServiceType(ServiceInvoiceServiceTypeDto serviceTypeDto) {
        return serviceInvoiceServiceTypeRepository
                .findByType(serviceTypeDto.getType())
                .orElseGet(() -> {
                    ServiceInvoiceServiceType entity = mapServiceTypeDtoToEntity(serviceTypeDto);
                    return serviceInvoiceServiceTypeRepository.save(entity);
                });
    }

    private ServiceInvoiceInfo mapDtoToEntity(ServiceInvoiceInfoDto dto, ServiceInvoiceServiceType serviceType,
                                              Invoice invoice) {
        ServiceInvoiceInfo entity = new ServiceInvoiceInfo();
        entity.setName(dto.getName());
        entity.setServiceType(serviceType);
        entity.setDate(dto.getDate());
        entity.setScope(dto.getScope());
        entity.setInvoice(invoice);
        return entity;
    }

    private ServiceInvoiceServiceType mapServiceTypeDtoToEntity(ServiceInvoiceServiceTypeDto dto) {
        ServiceInvoiceServiceType entity = new ServiceInvoiceServiceType();
        entity.setType(dto.getType());
        return entity;
    }

    private ServiceInvoiceInfoDto mapEntityToDto(ServiceInvoiceInfo entity) {
        return ServiceInvoiceInfoDto.builder()
                .name(entity.getName())
                .date(entity.getDate())
                .scope(entity.getScope())
                .serviceType(mapServiceTypeEntityToDto(entity.getServiceType()))
                .build();
    }

    private ServiceInvoiceServiceTypeDto mapServiceTypeEntityToDto(ServiceInvoiceServiceType entity) {
        return ServiceInvoiceServiceTypeDto.builder()
                .type(entity.getType())
                .build();
    }
}
