package com.example.aoms.database.invoice_product.service;

import com.example.aoms.database.invoice_product.dto.ProductInvoiceInfoDto;
import com.example.aoms.database.invoice_product.repository.ProductInvoiceInfoRepository;
import com.example.aoms.database.invoice_product.repository.ProductInvoiceProductTypeRepository;
import com.example.aoms.database.invoice_product.dto.ProductInvoiceProductTypeDto;
import com.example.aoms.database.invoice_product.entity.ProductInvoiceInfo;
import com.example.aoms.database.invoice_product.entity.ProductInvoiceProductType;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductInvoiceInfoServiceImpl implements ProductInvoiceInfoService {

    private final ProductInvoiceInfoRepository productInvoiceInfoRepository;
    private final ProductInvoiceProductTypeRepository productInvoiceProductTypeRepository;


    @Override
    @Transactional
    public ProductInvoiceInfo save(ProductInvoiceInfoDto dto) {
        ProductInvoiceProductType productType = findOrCreateProductType(dto.getProductType());
        ProductInvoiceInfo entity = mapDtoToEntity(dto, productType);
        return productInvoiceInfoRepository.save(entity);
    }

    @SneakyThrows
    private ProductInvoiceProductType findOrCreateProductType(ProductInvoiceProductTypeDto productTypeDto) {
        return productInvoiceProductTypeRepository
                .findByType(productTypeDto.getType())
                .orElseGet(() -> {
                    ProductInvoiceProductType entity = mapProductTypeDtoToEntity(productTypeDto);
                    return productInvoiceProductTypeRepository.save(entity);
                });
    }

    private ProductInvoiceProductType mapProductTypeDtoToEntity(ProductInvoiceProductTypeDto dto) {
        ProductInvoiceProductType entity = new ProductInvoiceProductType();
        entity.setType(dto.getType());
        return entity;
    }

    private ProductInvoiceInfo mapDtoToEntity(ProductInvoiceInfoDto dto, ProductInvoiceProductType productType) {
        ProductInvoiceInfo entity = new ProductInvoiceInfo();
        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
        entity.setQuantity(dto.getQuantity());
        entity.setProductType(productType);
        return entity;
    }

    private ProductInvoiceInfoDto mapEntityToDto(ProductInvoiceInfo entity) {
        return ProductInvoiceInfoDto.builder()
                .name(entity.getName())
                .date(entity.getDate())
                .quantity(entity.getQuantity())
                .productType(mapProductTypeEntityToDto(entity.getProductType()))
                .build();
    }

    private ProductInvoiceProductTypeDto mapProductTypeEntityToDto(ProductInvoiceProductType entity) {
        return ProductInvoiceProductTypeDto.builder()
                .type(entity.getType())
                .build();
    }
}
