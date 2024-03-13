package com.example.aoms.invoice;

import com.example.aoms.address.dto.AddressDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDto {
    private String name;
    private String NIP;
    private AddressDto addressDto;
}
