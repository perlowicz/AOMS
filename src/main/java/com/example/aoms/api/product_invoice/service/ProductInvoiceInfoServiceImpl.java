package com.example.aoms.api.product_invoice.service;

import com.example.aoms.api.invoice.entity.Invoice;
import com.example.aoms.api.product_invoice.dto.ProductInvoiceInfoDto;
import com.example.aoms.api.product_invoice.mapper.ProductInvoiceMapper;
import com.example.aoms.api.product_invoice.repository.ProductInvoiceInfoRepository;
import com.example.aoms.api.product_invoice.entity.ProductInvoiceInfo;
import com.example.aoms.api.unit_of_measure.dto.UnitOfMeasureDto;
import com.example.aoms.api.unit_of_measure.entity.UnitOfMeasure;
import com.example.aoms.api.unit_of_measure.mapper.UnitOfMeasureMapper;
import com.example.aoms.api.unit_of_measure.repository.UnitOfMeasureRepository;
import com.example.aoms.api.vat_rate.dto.VatRateDto;
import com.example.aoms.api.vat_rate.entity.VatRate;
import com.example.aoms.api.vat_rate.mapper.VatRateMapper;
import com.example.aoms.api.vat_rate.repository.VatRateRepository;
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
