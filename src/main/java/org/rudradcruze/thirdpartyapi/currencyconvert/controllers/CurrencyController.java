package org.rudradcruze.thirdpartyapi.currencyconvert.controllers;

import lombok.RequiredArgsConstructor;
import org.rudradcruze.thirdpartyapi.currencyconvert.services.CurrencyConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/currency")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyConversionService currencyConversionService;

    @GetMapping("/convert")
    public ResponseEntity<Map<String, Double>> convertCurrency(
            @RequestParam double amount,
            @RequestParam String baseCurrency,
            @RequestParam List<String> targetCurrencies) {
        return ResponseEntity.ok(currencyConversionService.convertCurrency(amount, baseCurrency, targetCurrencies));
    }
}