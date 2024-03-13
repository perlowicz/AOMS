package com.example.aoms.invoice_service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceInvoiceInfoDto {
    private String scope;
    private Instant date;
    private ServiceInvoiceServiceTypeDto serviceType;
}
