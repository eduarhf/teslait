package com.teslait.template.bill.infrastructure.outbound.converter;

import com.teslait.template.bill.domain.model.Bill;
import com.teslait.template.bill.infrastructure.outbound.model.Factura;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

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

        return bill;
    }

}
