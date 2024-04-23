package com.example.aoms.api.dto;

import com.example.aoms.api.dto.AddressDto;
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
    // FIXME Now company entity has foreign key to user table
}
