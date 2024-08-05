package org.rudradcruze.thirdpartyapi.currencyconvert.advice;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
@Builder
public class ApiError {
    private HttpStatus status;
    private String message;
    private List<String> subErrors;
    private String info;
}
