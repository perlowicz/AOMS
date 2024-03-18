package com.example.aoms.api.invoice_product.dto;

import com.example.aoms.api.unit_of_measure.dto.UnitOfMeasureDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductInvoiceInfoDto {
    private String name;
    private Integer quantity;
    private Instant date;
    private BigDecimal nettoPrice;
    private BigDecimal bruttoPrice;
    private UnitOfMeasureDto unitOfMeasure;
}
