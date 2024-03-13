package com.example.aoms.invoice.dto;

import com.example.aoms.company.dto.CompanyDto;
import com.example.aoms.customer.dto.CustomerDto;
import com.example.aoms.invoice_product.dto.ProductInvoiceInfoDto;
import com.example.aoms.invoice_service.dto.ServiceInvoiceInfoDto;
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
