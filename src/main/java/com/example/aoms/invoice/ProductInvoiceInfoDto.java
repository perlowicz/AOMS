package com.example.aoms.invoice;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class ProductInvoiceInfoDto {
    private String type;
    private Integer quantity;
    private Instant date;
}
