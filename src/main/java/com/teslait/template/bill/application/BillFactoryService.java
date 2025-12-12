package com.teslait.template.bill.application;

import com.teslait.template.bill.domain.port.in.BillPort;
import com.teslait.template.framework.CountryEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
@Component
public class BillFactoryService implements BillFactory {

    private Map<CountryEnum, BillPort> strategiesService;
    @Autowired
    public BillFactoryService(Set<BillPort> strategiesSet){
        strategiesService = new HashMap<>();
        strategiesSet.forEach(serviceImpl -> strategiesService.put(serviceImpl.getCountry(), serviceImpl));

    }

    public BillPort findStrategy(CountryEnum country) {
        log.info("BillFactoryService : findStrategy");
        return strategiesService.get(country);
    }
}
