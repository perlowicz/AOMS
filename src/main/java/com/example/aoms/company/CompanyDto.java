package com.example.aoms.company;

import com.example.aoms.address.AddressDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyDto {
    private AddressDto addressDto;
    private String name;
    private String NIP;
}
