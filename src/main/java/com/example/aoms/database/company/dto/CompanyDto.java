package com.example.aoms.database.company.dto;

import com.example.aoms.database.address.dto.AddressDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {
    private AddressDto address;
    private String name;
    private String NIP;
}
