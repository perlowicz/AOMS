package com.example.aoms.company.dto;

import com.example.aoms.address.dto.AddressDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyDto {
    private AddressDto address;
    private String name;
    private String NIP;
}
