package com.teslait.template.bill.application;

import com.teslait.template.bill.domain.model.Bill;
import com.teslait.template.bill.domain.port.in.BillPort;
import com.teslait.template.framework.CountryEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BillArgentinaService implements BillPort {
    //@Autowired
    //GetBillPort getStadisticPort;

    @Override
    public List<Bill> bills() {
        log.info("BillServiceAR : bills AR");
        return List.of();
    }

    @Override
    public CountryEnum getCountry() {
        return CountryEnum.AR;
    }
}
