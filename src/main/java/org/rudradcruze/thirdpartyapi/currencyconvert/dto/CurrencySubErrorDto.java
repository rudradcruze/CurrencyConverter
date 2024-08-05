package org.rudradcruze.thirdpartyapi.currencyconvert.dto;

import lombok.Data;

import java.util.List;

@Data
public class CurrencySubErrorDto {
    private List<String> currencies;
}
