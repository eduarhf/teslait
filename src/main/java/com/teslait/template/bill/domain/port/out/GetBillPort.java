package com.teslait.template.bill.domain.port.out;

import com.teslait.template.bill.domain.model.Bill;
import java.util.List;

public interface GetBillPort {

    List<Bill> getBills();
}
