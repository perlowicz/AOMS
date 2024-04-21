package com.example.aoms.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private CountryDto country;
    private String city;
    private String streetName;
    private Integer streetNumber;
}
