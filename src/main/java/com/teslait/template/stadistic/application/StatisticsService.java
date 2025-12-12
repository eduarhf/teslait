package com.teslait.template.stadistic.application;

import com.teslait.template.stadistic.domain.model.Agency;
import com.teslait.template.stadistic.domain.model.Product;
import com.teslait.template.stadistic.domain.model.StadisticAll;
import com.teslait.template.stadistic.domain.port.in.StadisticPort;
import com.teslait.template.stadistic.domain.port.out.GetStadisticPort;
import com.teslait.template.stadistic.infrastructure.outbound.adapter.StatisticsGrouper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StatisticsService implements StadisticPort {
    @Autowired
    GetStadisticPort getStadisticPort;
    @Override
    public List<StadisticAll> stadistics() {
        log.info("StatisticsService : stadistics");
        List<StadisticAll> stadistics = getStadisticPort.getStadistics();

        List<Agency> agencies = StatisticsGrouper.groupByAgency(stadistics);
        //log.info("agencies.size(): "+agencies.size());
        //for (Agency agency : agencies) {
        //    log.info("agency: "+agency.getAgency()+" product: "+agency.getProduct());
        //}
        List<Product> products = StatisticsGrouper.groupByProduct(stadistics);
        //for (Product product : products) {
        //    log.info("product: "+product.getProduct());
        //    log.info("date: "+product.getDate());
        //}
        //log.info("products.size(): "+products.size());
        return stadistics;
    }
}
