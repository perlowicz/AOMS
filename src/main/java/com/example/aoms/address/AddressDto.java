package com.example.aoms.address;

import com.example.aoms.country.CountrySaveDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {
    private CountrySaveDto country;
    private String city;
    private String streetName;
    private Integer streetNumber;
}
