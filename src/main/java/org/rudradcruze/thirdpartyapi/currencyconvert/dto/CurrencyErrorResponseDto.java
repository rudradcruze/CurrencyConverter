package org.rudradcruze.thirdpartyapi.currencyconvert.dto;

import lombok.Data;

@Data
public class CurrencyErrorResponseDto {
    private String message;
    private CurrencySubErrorDto errors;
    private String info;
}
