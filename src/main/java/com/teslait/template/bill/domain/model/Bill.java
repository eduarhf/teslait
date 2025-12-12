package com.teslait.template.bill.domain.model;

import lombok.Data;

@Data
public class Bill {
    private String agency;
    private String product;
    private String batch;
    private String batchResponse;

}
