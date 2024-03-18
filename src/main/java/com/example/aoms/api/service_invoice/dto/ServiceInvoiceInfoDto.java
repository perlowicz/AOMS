package com.example.aoms.api.service_invoice.dto;

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
public class ServiceInvoiceInfoDto {
    private String name;
    private String scope;
    private Instant date;
    private BigDecimal nettoPrice;
    private BigDecimal bruttoPrice;
}
