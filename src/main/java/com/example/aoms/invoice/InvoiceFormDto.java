package com.example.aoms.invoice;

import com.example.aoms.company.dto.CompanyDto;
import com.example.aoms.invoice_product.dto.ProductInvoiceInfoDto;
import com.example.aoms.invoice_service.dto.ServiceInvoiceInfoDto;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
public class InvoiceFormDto {
    private String number;
    private Instant date;
    private Double taxRate;
    private Double nettoRate;
    private Double bruttoRate;
    private Double overallValue;
    private ServiceInvoiceInfoDto serviceInvoiceInfo;
    private ProductInvoiceInfoDto productInvoiceInfo;
    private CompanyDto companyDto;
    private CustomerDto customerDto;
}
