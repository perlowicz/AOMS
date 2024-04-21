package com.example.aoms.api.mapper;

import com.example.aoms.api.entity.Invoice;
import com.example.aoms.api.dto.ProductInvoiceInfoDto;
import com.example.aoms.api.entity.ProductInvoiceInfo;
import com.example.aoms.api.entity.UnitOfMeasure;
import com.example.aoms.api.entity.VatRate;

public class ProductInvoiceMapper {

    public static ProductInvoiceInfo mapDtoToEntity(ProductInvoiceInfoDto dto, UnitOfMeasure unit, VatRate vatRate,
                                                    Invoice invoice) {
        ProductInvoiceInfo entity = new ProductInvoiceInfo();
        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
        entity.setQuantity(dto.getQuantity());
        entity.setNettoPrice(dto.getNettoPrice());
        entity.setBruttoPrice(dto.getBruttoPrice());
        entity.setUnitOfMeasure(unit);
        entity.setInvoice(invoice);
        entity.setNettoValue(dto.getNettoValue());
        entity.setBruttoValue(dto.getBruttoValue());
        entity.setVatRate(vatRate);
        entity.setVatValue(dto.getVatValue());
        return entity;
    }
}
