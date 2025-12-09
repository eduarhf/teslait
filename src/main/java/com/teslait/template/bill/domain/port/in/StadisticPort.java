package com.teslait.template.bill.domain.port.in;

import com.teslait.template.stadistic.domain.model.StadisticAll;
import java.util.List;

public interface StadisticPort {

    List<StadisticAll> stadistics();
}
