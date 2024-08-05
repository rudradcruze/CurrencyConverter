package org.rudradcruze.thirdpartyapi.currencyconvert.services;

import lombok.RequiredArgsConstructor;
import org.rudradcruze.thirdpartyapi.currencyconvert.client.CurrencyClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CurrencyConversionService {

    private final CurrencyClient currencyClient;

    public Map<String, Double> convertCurrency(double amount, String fromCurrency, List<String> toCurrencies) {
        Map<String, Double> convertedAmounts = currencyClient.getCurrencyConversionRate(fromCurrency, toCurrencies);
        try {
            convertedAmounts = convertedAmounts.entrySet().stream()
                    .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue() * amount));
        } catch (Exception e) {
            throw new RuntimeException("Currency conversion failed");
        }
        return convertedAmounts;
    }
}
