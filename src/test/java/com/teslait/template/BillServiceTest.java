package com.teslait.template;


import com.teslait.template.bill.application.BillService;
import com.teslait.template.bill.domain.model.Bill;
import com.teslait.template.bill.domain.port.out.GetBillPort;
import com.teslait.template.bill.infrastructure.outbound.converter.BillConverter;
import com.teslait.template.bill.infrastructure.outbound.model.Factura;
import com.teslait.template.framework.WireMockConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@Slf4j
@Import({WireMockConfiguration.class, JacksonAutoConfiguration.class})
@ExtendWith(MockitoExtension.class)
class BillServiceTest {

	@InjectMocks
	BillService billService;
	@Mock
	GetBillPort getBillPort;
	@Mock
	BillConverter billConverter;

	@BeforeEach
	void setup(){
		MockitoAnnotations.openMocks(this);
	}
	@Test
	void bills() {
		List<Factura> bills = new ArrayList<>();
		Factura bill = new Factura();
		bill.setNombreCliente("Diego");
		bill.setNumeroFactura("123384848");
		bill.setMontoFactura("1000");
		bill.setPais("AR");
		bill.setFechaFactura("2025-05-25T10:15:30.010-00:00");
		bill.setFechaVencimiento("2025-1");
		bills.add(bill);
		List<Bill> billsResult = bills.stream()
				.map(billConverter::convert)
				.collect(Collectors.toList());
		when(getBillPort.getBills()).thenReturn(billsResult);
		List<Bill> billsService = billService.bills();
		log.info("Test BillService bills executed "+billsService.size());
		assertNotNull(billsService);

	}
}
