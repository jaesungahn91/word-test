package com.js.vocatest.config.controlleradvice;

import com.js.vocatest.config.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j

//
@RestControllerAdvice
public class RestControllerExceptionAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    public ErrorResponse handlerRuntimeException(RuntimeException e, HttpServletRequest req) {
        log.error("=============== Handler RuntimeException ===============");
        e.printStackTrace();
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(), null);
    }
}
