package com.example.aoms.database.invoice_product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductInvoiceInfoDto {
    private String name;
    private Integer quantity;
    private Instant date;
    private ProductInvoiceProductTypeDto productType;
}
