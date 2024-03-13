package com.example.aoms.invoice_service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ServiceInvoiceInfoServiceImpl implements ServiceInvoiceInfoService {

    private final ServiceInvoiceInfoRepository serviceInvoiceInfoRepository;
    private final ServiceInvoiceServiceTypeRepository serviceInvoiceServiceTypeRepository;


    @Override
    @Transactional
    public ServiceInvoiceInfoDto save(ServiceInvoiceInfoDto dto) {
        ServiceInvoiceServiceType serviceType = findServiceType(dto.getServiceType());
        ServiceInvoiceInfo entity = mapDtoToEntity(dto, serviceType);
        ServiceInvoiceInfo savedEntity = serviceInvoiceInfoRepository.save(entity);
        return mapEntityToDto(savedEntity);
    }

    @SneakyThrows
    private ServiceInvoiceServiceType findServiceType(ServiceInvoiceServiceTypeDto serviceTypeDto) {
        return serviceInvoiceServiceTypeRepository
                .findByType(serviceTypeDto.getType())
                .orElseGet(() -> {
                    ServiceInvoiceServiceType entity = mapServiceTypeDtoToEntity(serviceTypeDto);
                    return serviceInvoiceServiceTypeRepository.save(entity);
                });
    }

    private ServiceInvoiceInfo mapDtoToEntity(ServiceInvoiceInfoDto dto, ServiceInvoiceServiceType serviceType) {
        ServiceInvoiceInfo entity = new ServiceInvoiceInfo();
        entity.setServiceType(serviceType);
        entity.setDate(dto.getDate());
        entity.setScope(dto.getScope());
        return entity;
    }

    private ServiceInvoiceServiceType mapServiceTypeDtoToEntity(ServiceInvoiceServiceTypeDto dto) {
        ServiceInvoiceServiceType entity = new ServiceInvoiceServiceType();
        entity.setType(dto.getType());
        return entity;
    }

    private ServiceInvoiceInfoDto mapEntityToDto(ServiceInvoiceInfo entity) {
        return ServiceInvoiceInfoDto.builder()
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
