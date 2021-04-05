package com.js.vocatest.config.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
//@AllArgsConstructor
//@NoArgsConstructor
public class ErrorResponse {
    private int code;
    private String message;
    private List<String> errorDetails;
    private String responseTime;

    public ErrorResponse(int code, String message, List<String> errorDetails) {
        this.code = code;
        this.message = message;
        this.errorDetails = errorDetails;
        this.responseTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
    }
}
