package com.teslait.template.bill.infrastructure.inbound.api.adapter;

import com.teslait.template.bill.application.BillFactoryService;
import com.teslait.template.bill.domain.model.Bill;
import com.teslait.template.bill.domain.port.in.BillPort;
import com.teslait.template.framework.ChannelEnum;
import com.teslait.template.framework.CountryEnum;
import com.teslait.template.framework.MainController;
import com.teslait.template.stadistic.domain.model.StadisticAll;
import com.teslait.template.stadistic.domain.port.in.StadisticPort;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/bills")
public class BillController extends MainController {

    @Autowired
    private BillFactoryService billFactoryService;
    @Autowired
    private HttpServletRequest request;
    @GetMapping
    public ResponseEntity<List<Bill>> statistics(){

        CountryEnum countryEnum = CountryEnum.valueOf(request.getHeader("country"));
        logEntry(UUID.randomUUID(), ChannelEnum.WEB, countryEnum);
        final BillPort service = billFactoryService.findStrategy(countryEnum);

        return ResponseEntity.ok().headers(new HttpHeaders(create())).body(service.bills());
    }
}
