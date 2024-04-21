package com.example.aoms.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDto {
    private String number;
    private Instant date;
    private BigDecimal taxRate;
    private BigDecimal nettoRate;
    private BigDecimal bruttoRate;
    private BigDecimal overallValue;
    private CompanyDto company;
    private CustomerDto customer;
    private List<ProductInvoiceInfoDto> listOfProductInvoiceInfo;
    private List<ServiceInvoiceInfoDto> listOfServiceInvoiceInfo;
}
