package com.teslait.template.bill.domain.port.out;

import com.teslait.template.stadistic.domain.model.StadisticAll;

import java.util.List;

public interface GetStadisticPort {

    List<StadisticAll> getStadistics();
}
