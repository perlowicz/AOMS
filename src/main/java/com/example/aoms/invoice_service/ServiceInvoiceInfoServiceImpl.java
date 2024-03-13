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
    public ServiceInvoiceInfo save(ServiceInvoiceInfoDto dto) {
        ServiceInvoiceServiceType serviceType = findServiceType(dto.getServiceType().getType());
        ServiceInvoiceInfo entity = mapDtoToEntity(dto, serviceType);
        return serviceInvoiceInfoRepository.save(entity);
    }

    @SneakyThrows
    private ServiceInvoiceServiceType findServiceType(String type) {
        return serviceInvoiceServiceTypeRepository
                .findByType(type)
                .orElseThrow(() -> new IllegalArgumentException("Service type not found: " + type));
    }

    private ServiceInvoiceInfo mapDtoToEntity(ServiceInvoiceInfoDto dto, ServiceInvoiceServiceType serviceType) {
        ServiceInvoiceInfo entity = new ServiceInvoiceInfo();
        entity.setServiceType(serviceType);
        entity.setDate(dto.getDate());
        entity.setScope(dto.getScope());
        return entity;
    }
}
