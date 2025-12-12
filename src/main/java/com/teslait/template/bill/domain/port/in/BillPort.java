package com.teslait.template.bill.domain.port.in;

import com.teslait.template.bill.domain.model.Bill;
import com.teslait.template.framework.CountryEnum;

import java.util.List;

public interface BillPort {

    List<Bill> bills();
    CountryEnum getCountry();
}
