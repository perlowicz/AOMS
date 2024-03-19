package com.example.aoms.api.user.data.token;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VerificationTokenInfo {
    private String message;
    private Boolean isValid;
}
