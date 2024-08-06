package org.rudradcruze.thirdpartyapi.currencyconvert.client.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.rudradcruze.thirdpartyapi.currencyconvert.client.CurrencyClient;
import org.rudradcruze.thirdpartyapi.currencyconvert.dto.CurrencySuccessResponseDto;
import org.rudradcruze.thirdpartyapi.currencyconvert.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CurrencyClientImpl implements CurrencyClient {

    private final RestClient restClient;
    Logger log = LoggerFactory.getLogger(CurrencyClientImpl.class);

    @Value("${currencyService.api.key}")
    private String apiKey;

    @Override
    public Map<String, Double> getCurrencyConversionRate(String fromCurrency, List<String> toCurrencies) {
        String url = "/latest?apikey=" + apiKey + "&currencies=" + String.join(",", toCurrencies) + "&base_currency=" + fromCurrency;
        log.trace("Trying to retrieve the currency conversion rate in getCurrencyConversionRate");
        log.trace("URL : {}", url);
        try {
            log.trace("Attempting to call the restClient Method in getCurrencyConversionRate");
            CurrencySuccessResponseDto apiResponse = restClient.get()
                    .uri(url)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                        String errorBody = new String(response.getBody().readAllBytes());
                        log.error("Client Error occurred in getCurrencyConversionRate : {}", errorBody);
                        throw new ResourceNotFoundException(errorBody);
                    })
                    .body(new ParameterizedTypeReference<>() {});
            log.debug("Successfully retrieved the currency conversion rate in getCurrencyConversionRate");
            return apiResponse.getRates();
        } catch (RuntimeException e) {
            log.error("Exception occurred in getCurrencyConversionRate", e.getMessage());
            throw new ResourceNotFoundException(e.getMessage());
        }
    }
}