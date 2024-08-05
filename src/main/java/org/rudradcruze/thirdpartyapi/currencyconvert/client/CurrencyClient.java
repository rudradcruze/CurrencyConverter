package org.rudradcruze.thirdpartyapi.currencyconvert.client;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface CurrencyClient {
    Map<String, Double> getCurrencyConversionRate(String fromCurrency, List<String> toCurrencies);
}
