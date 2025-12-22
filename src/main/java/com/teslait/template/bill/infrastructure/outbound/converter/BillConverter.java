package com.teslait.template.bill.infrastructure.outbound.converter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.teslait.template.bill.domain.model.Bill;
import com.teslait.template.bill.infrastructure.outbound.model.Factura;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.OffsetDateTime;
@Slf4j
@Component
public class BillConverter implements Converter<Factura, Bill> {

    @Override
    public Bill convert(Factura source) {
        Bill bill = new Bill(
                source.getNombreCliente(),
                source.getNumeroFactura(),source.getPais(),
                source.getMontoFactura(),
                source.getFechaFactura(),
                source.getFechaVencimiento());

        //final Instant invoiceDate = OffsetDateTime.parse(source.getFechaFactura()).toInstant();
        //final Instant dueDate = OffsetDateTime.parse(source.getFechaVencimiento()).toInstant();
        //final boolean dataDiff = OffsetDateTime
        //        .parse(source.getFechaVencimiento())
        //        .isBefore(OffsetDateTime.now());
        //log.info("Data diff dueDate vs now: {}", dataDiff);
        //bill.setCustomerName(source.getNombreCliente());
        //bill.setInvoiceNumber(source.getNumeroFactura());
        //bill.setCountry(source.getPais());
        //bill.setInvoiceAmount(source.getMontoFactura());
        //bill.setInvoiceDate(String.valueOf(invoiceDate));
        //bill.setDueDate(source.getFechaVencimiento());

        //String statusValue= "Por Vencer";
        //if(dataDiff){
        //    statusValue = "Vencida";
        //}
        //log.info("statusValue: "+ statusValue);
        //bill.setStatus(statusValue);
        return bill;
    }

}
