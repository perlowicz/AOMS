package com.example.aoms.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClientDto {
    String fullName;
    Integer NIP;
}
