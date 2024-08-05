package org.rudradcruze.thirdpartyapi.currencyconvert.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Map;

@Data
@Getter
@Service
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CurrencySuccessResponseDto {
    @JsonProperty("data")
    private Map<String, Double> rates;
}
