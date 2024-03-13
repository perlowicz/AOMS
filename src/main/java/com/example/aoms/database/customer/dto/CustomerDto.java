package com.example.aoms.database.customer.dto;

import com.example.aoms.database.address.dto.AddressDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private String name;
    private String NIP;
    private AddressDto address;
}
