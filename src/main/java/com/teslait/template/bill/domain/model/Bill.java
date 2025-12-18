package com.teslait.template.bill.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class Bill {
    private String customerName;
    private String invoiceNumber;
    private String country;
    private String invoiceAmount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private String invoiceDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private String dueDate;
    private String status;

}
