package org.rudradcruze.thirdpartyapi.currencyconvert.advice;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {
    private T data;
    private ApiError error;
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    public ApiResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse(ApiError error, T data) {
        this.error = error;
        this.data = data;
    }

    public ApiResponse(ApiError error) {
        this();
        this.error = error;
    }
}
