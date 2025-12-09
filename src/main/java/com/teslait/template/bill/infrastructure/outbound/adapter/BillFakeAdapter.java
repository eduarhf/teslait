package com.teslait.template.bill.infrastructure.outbound.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teslait.template.stadistic.domain.model.StadisticAll;
import com.teslait.template.stadistic.domain.model.StadisticResponse;
import com.teslait.template.stadistic.domain.port.out.GetStadisticPort;
import com.teslait.template.stadistic.infrastructure.outbound.model.StatisticsEntity;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
//@Component
public class BillFakeAdapter implements GetStadisticPort {

    @Override
    public List<StadisticAll> getStadistics() {
        List<StadisticAll> stadistics = new ArrayList<>();
        StadisticAll stadisticAll = new StadisticAll();
        stadisticAll.setProduct("INFORME");
        stadisticAll.setAgency("quilicura");
        stadisticAll.setUser("test");
        stadisticAll.setDate("2025-05-26");
        stadisticAll.setBillIndicator("Y");
        stadisticAll.setLineOfService("Internet");
        stadistics.add(stadisticAll);

        stadisticAll = new StadisticAll();
        stadisticAll.setProduct("INFORME");
        stadisticAll.setAgency("quilicura");
        stadisticAll.setUser("test");
        stadisticAll.setDate("2025-05-27");
        stadisticAll.setBillIndicator("N");
        stadisticAll.setLineOfService("Mobile");
        stadistics.add(stadisticAll);

        stadisticAll = new StadisticAll();
        stadisticAll.setProduct("INFORME");
        stadisticAll.setAgency("Conchali");
        stadisticAll.setUser("prod");
        stadisticAll.setDate("2025-05-26");
        stadisticAll.setBillIndicator("Y");
        stadisticAll.setLineOfService("Mobile");
        stadistics.add(stadisticAll);

        return stadistics;
    }
}
