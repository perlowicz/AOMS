package com.example.aoms.api.service;

import com.example.aoms.api.entity.Invoice;
import com.example.aoms.api.dto.ProductInvoiceInfoDto;
import com.example.aoms.api.mapper.ProductInvoiceMapper;
import com.example.aoms.api.repository.ProductInvoiceInfoRepository;
import com.example.aoms.api.entity.ProductInvoiceInfo;
import com.example.aoms.api.dto.UnitOfMeasureDto;
import com.example.aoms.api.entity.UnitOfMeasure;
import com.example.aoms.api.mapper.UnitOfMeasureMapper;
import com.example.aoms.api.repository.UnitOfMeasureRepository;
import com.example.aoms.api.dto.VatRateDto;
import com.example.aoms.api.entity.VatRate;
import com.example.aoms.api.mapper.VatRateMapper;
import com.example.aoms.api.repository.VatRateRepository;
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
    private final VatRateRepository vatRateRepository;


    @Override
    @Transactional
    public ProductInvoiceInfo save(ProductInvoiceInfoDto dto, Invoice invoice) {
        UnitOfMeasure unitOfMeasure = findOrCreateUnitOfMeasure(dto.getUnitOfMeasure());
        VatRate vatRate = findOrCreateVatRate(dto.getVatRate());
        ProductInvoiceInfo entity = ProductInvoiceMapper.mapDtoToEntity(dto, unitOfMeasure, vatRate, invoice);
        return productInvoiceInfoRepository.save(entity);
    }

    @Override
    @Transactional
    public void saveAll(List<ProductInvoiceInfoDto> dtoList, Invoice invoice) {
        List<ProductInvoiceInfo> entities = dtoList.stream()
                .map(dto -> {
                    UnitOfMeasure unitOfMeasure = findOrCreateUnitOfMeasure(dto.getUnitOfMeasure());
                    VatRate vatRate = findOrCreateVatRate(dto.getVatRate());
                    return ProductInvoiceMapper.mapDtoToEntity(dto, unitOfMeasure, vatRate, invoice);
                })
                .collect(Collectors.toList());
        productInvoiceInfoRepository.saveAll(entities);
    }

    @SneakyThrows
    private UnitOfMeasure findOrCreateUnitOfMeasure(UnitOfMeasureDto dto) {
        return unitOfMeasureRepository
                .findUnitOfMeasureByUnit(dto.getUnit())
                .orElseGet(() -> {
                    UnitOfMeasure entity = UnitOfMeasureMapper.mapDtoToEntity(dto);
                    return unitOfMeasureRepository.save(entity);
                });
    }

    @SneakyThrows
    private VatRate findOrCreateVatRate(VatRateDto dto) {
        return vatRateRepository
                .findVatRateByRate(dto.getRate())
                .orElseGet(() -> {
                    VatRate entity = VatRateMapper.mapDtoToEntity(dto);
                    return vatRateRepository.save(entity);
                });
    }
}
