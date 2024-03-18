package com.example.aoms.api.invoice_product.service;

import com.example.aoms.api.invoice.entity.Invoice;
import com.example.aoms.api.invoice_product.dto.ProductInvoiceInfoDto;
import com.example.aoms.api.invoice_product.repository.ProductInvoiceInfoRepository;
import com.example.aoms.api.invoice_product.entity.ProductInvoiceInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductInvoiceInfoServiceImpl implements ProductInvoiceInfoService {

    private final ProductInvoiceInfoRepository productInvoiceInfoRepository;


    @Override
    @Transactional
    public ProductInvoiceInfo save(ProductInvoiceInfoDto dto, Invoice invoice) {
        ProductInvoiceInfo entity = mapDtoToEntity(dto, invoice);
        return productInvoiceInfoRepository.save(entity);
    }

    @Override
    @Transactional
    public List<ProductInvoiceInfo> saveAll(List<ProductInvoiceInfoDto> dtoList, Invoice invoice) {
        List<ProductInvoiceInfo> entities = dtoList.stream()
                .map(dto -> mapDtoToEntity(dto, invoice))
                .collect(Collectors.toList());
        return productInvoiceInfoRepository.saveAll(entities);
    }

    private ProductInvoiceInfo mapDtoToEntity(ProductInvoiceInfoDto dto, Invoice invoice) {
        ProductInvoiceInfo entity = new ProductInvoiceInfo();
        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
        entity.setQuantity(dto.getQuantity());
        entity.setNettoPrice(dto.getNettoPrice());
        entity.setBruttoPrice(dto.getBruttoPrice());
        entity.setInvoice(invoice);
        return entity;
    }

    private ProductInvoiceInfoDto mapEntityToDto(ProductInvoiceInfo entity) {
        return ProductInvoiceInfoDto.builder()
                .name(entity.getName())
                .date(entity.getDate())
                .quantity(entity.getQuantity())
                .nettoPrice(entity.getNettoPrice())
                .bruttoPrice(entity.getBruttoPrice())
                .build();
    }
}
