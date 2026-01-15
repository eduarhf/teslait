package com.teslait.template.bill.application;

import com.teslait.template.bill.domain.model.Bill;
import com.teslait.template.bill.domain.port.in.BillPort;
import com.teslait.template.bill.domain.port.out.GetBillPort;
import com.teslait.template.framework.CountryEnum;
import com.teslait.template.stadistic.domain.model.StadisticAll;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BillArgentinaService implements BillPort {
    @Autowired
    GetBillPort getBillPort;
    @Autowired
    CustomMetricService customMetricService;
    @Override
    public List<Bill> bills() {

        log.info("BillArgentinaService : country: "+CountryEnum.AR.code());
        customMetricService.executeBusinessLogic();
        List<Bill> billsRepository = getBillPort.getBills();
        getMaxByDate(billsRepository);
        log.info("billsRepository size: "+ billsRepository.size());
        Collections.sort(billsRepository, new Comparator<Bill>() {
            @Override
            public int compare(Bill o1, Bill o2) {
                return o1.getDueDate().compareTo(o2.getDueDate());
            }
        });
        billsRepository.forEach(bill ->
                log.info("Sorted InvoiceNumber: "+ bill.getInvoiceNumber()+" InvoiceDate: "+ bill.getInvoiceDate())
        );

        final Map<String, List<Bill>> groupInvoiceNumber =
                billsRepository.stream().collect(
                        Collectors.groupingBy(groupA -> groupA.getInvoiceNumber()));

        groupInvoiceNumber.forEach((k,v) ->
                log.info("DueDate: "+k+" InvoiceNumber: "+v.size())
        );
        for(final Map.Entry<String, List<Bill>> entryBill : groupInvoiceNumber.entrySet()) {
            log.info("Key: " + entryBill.getKey());
            entryBill.getValue().stream()
                    .forEach(bill ->
                            log.info("   InvoiceNumber: " + bill.getInvoiceNumber()
                                    + " DueDate: " + bill.getDueDate())
                    );;
        }
        Bill ultimoRegistro = billsRepository.get(billsRepository.size() - 1);

        List<Bill> result = new ArrayList<>();
        result.add(ultimoRegistro);
        log.info("result size: "+ result.size());
        return result;
    }
    private void getMaxByDate(List<Bill> bills){
        Map<String, Bill> ultimosRegistros = bills.stream()
                .collect(Collectors.groupingBy(Bill::getDueDate,
                        Collectors.maxBy(Comparator.comparing(Bill::getDueDate))))
                .values()
                .stream()
                .map(Optional::get)
                .collect(Collectors.toMap(Bill::getDueDate, Function.identity()));

        ultimosRegistros.forEach((k,v) ->
                log.info("DueDate: "+k+" InvoiceNumber: "+v.getInvoiceNumber())
        );

    }

    @Override
    public CountryEnum getCountry() {
        return CountryEnum.AR;
    }
}
