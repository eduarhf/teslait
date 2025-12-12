package com.teslait.template.framework;

import lombok.Data;

import java.time.Instant;

@Data
public class CustomErrorResponse {
    private String errorCode;
    private String errorMsg;
    private int status;
    private Instant timestamp;

}
