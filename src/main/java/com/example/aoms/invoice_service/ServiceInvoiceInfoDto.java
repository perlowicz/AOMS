package com.example.aoms.invoice_service;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class ServiceInvoiceInfoDto {
    private String scope;
    private Instant date;
    private ServiceInvoiceServiceTypeDto serviceType;
}
