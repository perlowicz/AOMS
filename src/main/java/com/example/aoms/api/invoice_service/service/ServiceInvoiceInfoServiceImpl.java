package com.example.aoms.api.invoice_service.service;

import com.example.aoms.api.invoice.entity.Invoice;
import com.example.aoms.api.invoice_service.dto.ServiceInvoiceInfoDto;
import com.example.aoms.api.invoice_service.entity.ServiceInvoiceInfo;
import com.example.aoms.api.invoice_service.repository.ServiceInvoiceInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceInvoiceInfoServiceImpl implements ServiceInvoiceInfoService {

    private final ServiceInvoiceInfoRepository serviceInvoiceInfoRepository;


    @Override
    @Transactional
    public ServiceInvoiceInfo save(ServiceInvoiceInfoDto dto, Invoice invoice) {
        ServiceInvoiceInfo entity = mapDtoToEntity(dto, invoice);
        return serviceInvoiceInfoRepository.save(entity);
    }

    @Override
    public List<ServiceInvoiceInfo> saveAll(List<ServiceInvoiceInfoDto> dtoList, Invoice invoice) {
        List<ServiceInvoiceInfo> entities = dtoList.stream()
                .map(dto -> mapDtoToEntity(dto, invoice))
                .collect(Collectors.toList());
        return serviceInvoiceInfoRepository.saveAll(entities);
    }

    private ServiceInvoiceInfo mapDtoToEntity(ServiceInvoiceInfoDto dto, Invoice invoice) {
        ServiceInvoiceInfo entity = new ServiceInvoiceInfo();
        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
        entity.setScope(dto.getScope());
        entity.setNettoPrice(dto.getNettoPrice());
        entity.setBruttoPrice(dto.getBruttoPrice());
        entity.setInvoice(invoice);
        return entity;
    }

    private ServiceInvoiceInfoDto mapEntityToDto(ServiceInvoiceInfo entity) {
        return ServiceInvoiceInfoDto.builder()
                .name(entity.getName())
                .date(entity.getDate())
                .scope(entity.getScope())
                .nettoPrice(entity.getNettoPrice())
                .bruttoPrice(entity.getBruttoPrice())
                .build();
    }
}
