package com.teslait.template.bill.application;

import com.teslait.template.bill.domain.port.in.BillPort;
import com.teslait.template.framework.CountryEnum;

public interface BillFactory {

    BillPort findStrategy(CountryEnum country);
}
