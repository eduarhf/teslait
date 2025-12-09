package com.teslait.template.framework;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value =IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException ex) {
        log.error("IllegalArgumentException: {}", ex.getMessage());
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Error-Type", "IllegalArgument");
        headers.add("Error-ID", UUID.randomUUID().toString());
        return ResponseEntity.badRequest().headers((HttpHeaders) headers).body(ex.getMessage());
    }
}
