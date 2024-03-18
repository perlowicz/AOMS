package com.example.aoms.api.invoice_product.service;

import com.example.aoms.api.invoice.entity.Invoice;
import com.example.aoms.api.invoice_product.dto.ProductInvoiceInfoDto;
import com.example.aoms.api.invoice_product.repository.ProductInvoiceInfoRepository;
import com.example.aoms.api.invoice_product.entity.ProductInvoiceInfo;
import com.example.aoms.api.unit_of_measure.dto.UnitOfMeasureDto;
import com.example.aoms.api.unit_of_measure.entity.UnitOfMeasure;
import com.example.aoms.api.unit_of_measure.repository.UnitOfMeasureRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductInvoiceInfoServiceImpl implements ProductInvoiceInfoService {

    private final ProductInvoiceInfoRepository productInvoiceInfoRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;


    @Override
    @Transactional
    public ProductInvoiceInfo save(ProductInvoiceInfoDto dto, Invoice invoice) {
        UnitOfMeasure unitOfMeasure = findOrCreateUnitOfMeasure(dto.getUnitOfMeasure());
        ProductInvoiceInfo entity = mapDtoToEntity(dto, unitOfMeasure, invoice);
        return productInvoiceInfoRepository.save(entity);
    }

    @Override
    @Transactional
    public List<ProductInvoiceInfo> saveAll(List<ProductInvoiceInfoDto> dtoList, Invoice invoice) {
        List<ProductInvoiceInfo> entities = dtoList.stream()
                .map(dto -> {
                    UnitOfMeasure unitOfMeasure = findOrCreateUnitOfMeasure(dto.getUnitOfMeasure());
                    return mapDtoToEntity(dto, unitOfMeasure, invoice);
                })
                .collect(Collectors.toList());
        return productInvoiceInfoRepository.saveAll(entities);
    }

    @SneakyThrows
    private UnitOfMeasure findOrCreateUnitOfMeasure(UnitOfMeasureDto dto) {
        return unitOfMeasureRepository
                .findUnitOfMeasureByUnit(dto.getUnit())
                .orElseGet(() -> {
                    UnitOfMeasure entity = mapUnitOfMeasureDtoToEntity(dto);
                    return unitOfMeasureRepository.save(entity);
                });
    }

    private UnitOfMeasure mapUnitOfMeasureDtoToEntity(UnitOfMeasureDto dto) {
        UnitOfMeasure entity = new UnitOfMeasure();
        entity.setUnit(dto.getUnit());
        return entity;
    }

    private ProductInvoiceInfo mapDtoToEntity(ProductInvoiceInfoDto dto, UnitOfMeasure unit, Invoice invoice) {
        ProductInvoiceInfo entity = new ProductInvoiceInfo();
        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
        entity.setQuantity(dto.getQuantity());
        entity.setNettoPrice(dto.getNettoPrice());
        entity.setBruttoPrice(dto.getBruttoPrice());
        entity.setUnitOfMeasure(unit);
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
