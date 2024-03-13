package com.example.aoms.company.dto;

import com.example.aoms.address.dto.AddressDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyDto {
    private AddressDto addressDto;
    private String name;
    private String NIP;
}
