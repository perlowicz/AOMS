package com.example.aoms.api.company.dto;

import com.example.aoms.api.address.dto.AddressDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {
    private String name;
    private String NIP;
    private AddressDto address;
    private String userName;
}
