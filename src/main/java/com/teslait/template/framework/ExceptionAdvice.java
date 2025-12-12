package com.teslait.template.framework;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<CustomErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        log.error("IllegalArgumentException: {}", ex.getMessage());

        CustomErrorResponse customErrorResponse = new CustomErrorResponse();
        customErrorResponse.setErrorCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        customErrorResponse.setErrorMsg(ex.getMessage());
        customErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        customErrorResponse.setTimestamp(java.time.Instant.now());
        return ResponseEntity.badRequest().body(customErrorResponse);
    }
    @ExceptionHandler(value =Exception.class)
    public ResponseEntity<CustomErrorResponse> handleException(Exception ex) {
        log.error("Exception: {}", ex.getMessage());

        CustomErrorResponse customErrorResponse = new CustomErrorResponse();
        customErrorResponse.setErrorCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        customErrorResponse.setErrorMsg(ex.getMessage());
        customErrorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        customErrorResponse.setTimestamp(java.time.Instant.now());
        return ResponseEntity.badRequest().body(customErrorResponse);
    }
}
