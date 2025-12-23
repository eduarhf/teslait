package com.teslait.template.bill.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Slf4j
@Data
public class Bill {
    private String customerName;
    private String invoiceNumber;
    private String country;
    private String invoiceAmount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private String invoiceDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    private String dueDate;
    private String status;

    public Bill(
            String customerName,
            String invoiceNumber,
            String country, String invoiceAmount, String invoiceDate, String dueDate) {

        Assert.notNull(customerName, "customerName must not be null");
        Assert.notNull(invoiceNumber, "invoiceNumber must not be null");

        this.customerName = customerName;
        this.invoiceNumber = invoiceNumber;
        this.country = country;
        this.invoiceAmount = invoiceAmount;
        this.invoiceDate = invoiceDate;
        this.dueDate = dueDate;
        final Instant invoiceDateDate = OffsetDateTime.parse(invoiceDate).toInstant();
        //pe
        final Instant invoiceDateDate2 = LocalDate.parse(invoiceDate).atStartOfDay().toInstant(ZoneOffset.UTC);

        final Instant dueDateDate = OffsetDateTime.parse(dueDate).toInstant();
        final boolean dataDiff = OffsetDateTime
                .parse(dueDate)
                .isBefore(OffsetDateTime.now());
        //log.info("Data diff dueDate vs now: {}", dataDiff);
        String statusValue= "Por Vencer";
        if(dataDiff){
            statusValue = "Vencida";
        }
        //log.info("statusValue: "+ statusValue);
        this.status = statusValue;
    }
}
