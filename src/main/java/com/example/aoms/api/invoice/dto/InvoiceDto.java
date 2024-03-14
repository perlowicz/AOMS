package com.example.aoms.api.invoice.dto;

import com.example.aoms.api.company.dto.CompanyDto;
import com.example.aoms.api.customer.dto.CustomerDto;
import com.example.aoms.api.invoice_product.dto.ProductInvoiceInfoDto;
import com.example.aoms.api.invoice_service.dto.ServiceInvoiceInfoDto;
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
public class InvoiceDto {
    private String number;
    private Instant date;
    private BigDecimal taxRate;
    private BigDecimal nettoRate;
    private BigDecimal bruttoRate;
    private BigDecimal overallValue;
    private CompanyDto company;
    private CustomerDto customer;
    private ServiceInvoiceInfoDto serviceInvoiceInfo;
    private ProductInvoiceInfoDto productInvoiceInfo;
}
