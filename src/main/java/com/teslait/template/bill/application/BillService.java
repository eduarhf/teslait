package com.teslait.template.bill.application;

import com.teslait.template.bill.domain.model.Bill;
import com.teslait.template.bill.domain.port.in.BillPort;
import com.teslait.template.bill.domain.port.out.GetBillPort;
import com.teslait.template.framework.CountryEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BillService implements BillPort {
    private static final String STATUS_APPROVED = "approved";
    private static final String STATUS_WAITING = "waiting";
    @Autowired
    GetBillPort getStadisticPort;

    @Override
    public List<Bill> bills() {
        log.info("BillServiceCL : bills");
        List<Bill> billsRepository = getStadisticPort.getBills();
        log.info("billsRepository size {}", billsRepository.size());
        List<Bill> billsFilter = billsRepository.stream()
                .filter(bill -> bill.getInvoiceNumber()!=null && !bill.getInvoiceNumber().isEmpty())
                .collect(Collectors.toList());
        log.info("billsFilter size {}", billsFilter.size());
        //billsFilter.forEach(bill -> bill.setCountry(CountryEnum.CL.code()));
        for(Bill bill : billsFilter){
            log.info("Bill filtered InvoiceNumber {}", bill.getInvoiceNumber());
            if(STATUS_APPROVED.equalsIgnoreCase(getExternalData(bill.getStatus()))){

                bill.setStatus(STATUS_WAITING);
            }
        }

        log.info("billsFilter size {}", billsFilter.size());
        return billsFilter;
    }
    private String getExternalData(String status){
        //Llamar a un servicio externo
        if(status.equalsIgnoreCase("pagada")){
            return "approved";
        }
        return status;
    }

    @Override
    public CountryEnum getCountry() {
        return CountryEnum.CL;
    }
}
