package com.teslait.template.bill.infrastructure.outbound.adapter;
import com.teslait.template.bill.domain.model.Bill;
import com.teslait.template.bill.domain.port.out.GetBillPort;
import com.teslait.template.bill.infrastructure.outbound.converter.BillConverter;
import com.teslait.template.bill.infrastructure.outbound.model.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BillFakeAdapter implements GetBillPort {

    @Autowired
    BillConverter billConverter;
    @Override
    public List<Bill> getBills() {

        List<Factura> bills = new ArrayList<>();
        Factura bill = new Factura();
        bill.setNombreCliente("Diego");
        bill.setNumeroFactura("123384848");
        bill.setMontoFactura("1000");
        bill.setPais("AR");
        bill.setFechaFactura("2025-05-25T10:15:30.010-00:00");
        bill.setFechaVencimiento("2025-12-18T10:15:30.010-00:00");
        bills.add(bill);

        bill = new Factura();
        bill.setNombreCliente("Eduardo");
        bill.setNumeroFactura("3333554");
        bill.setMontoFactura("1078800");
        bill.setPais("CL");
        bill.setFechaFactura("2025-05-26T10:15:30.010-00:00");
        bill.setFechaVencimiento("2025-12-16T15:15:30.010-00:00");
        bills.add(bill);

        bill = new Factura();
        bill.setNombreCliente("Pablo");
        bill.setNumeroFactura("56677");
        bill.setMontoFactura("1000");
        bill.setPais("PY");
        bill.setFechaFactura("2025-05-25T10:15:30.010-00:00");
        bill.setFechaVencimiento("2025-05-26T10:15:30.010-00:00");
        bills.add(bill);
        List<Bill> billsResult = bills.stream().map(billConverter::convert).collect(Collectors.toList());
        return billsResult;
    }
}
