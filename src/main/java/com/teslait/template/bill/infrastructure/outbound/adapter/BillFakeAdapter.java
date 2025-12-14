package com.teslait.template.bill.infrastructure.outbound.adapter;
import com.teslait.template.bill.domain.model.Bill;
import com.teslait.template.bill.domain.port.out.GetBillPort;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class BillFakeAdapter implements GetBillPort {

    @Override
    public List<Bill> getBills() {

        List<Bill> bills = new ArrayList<>();
        Bill bill = new Bill();
        bill.setProduct("INFORME");
        bill.setAgency("quilicura");
        bill.setBatchResponse("2025-05-26");
        bills.add(bill);
        return bills;
    }
}
