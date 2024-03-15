package com.example.aoms.api.address.dto;

import com.example.aoms.api.country.dto.CountryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private Long id;
    private CountryDto country;
    private String city;
    private String streetName;
    private Integer streetNumber;
}
