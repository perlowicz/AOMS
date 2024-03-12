package com.example.aoms.invoice;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class InvoiceFormDto {
    String companyName;
    String companyNIP;
    String customerName;
    String customerNIP;

}
