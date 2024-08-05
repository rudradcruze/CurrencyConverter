package org.rudradcruze.thirdpartyapi.currencyconvert.config;

import org.rudradcruze.thirdpartyapi.currencyconvert.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Configuration
public class RestClientConfig {

    @Value("${currencyService.base.url}")
    private String BASE_URL;

    @Bean
    @Qualifier("currencyConverterRestClient")
    public RestClient getCurrencyConverterRestClient() {
        return RestClient.builder()
                .baseUrl(BASE_URL)
                .defaultHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .defaultStatusHandler(HttpStatusCode::is5xxServerError, (request, response) -> {
                    throw new ResourceNotFoundException("Could not convert the currency.");
                })
                .build();
    }
}