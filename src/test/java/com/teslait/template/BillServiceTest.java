package com.teslait.template;

import com.teslait.template.bill.application.BillService;
import com.teslait.template.bill.domain.port.out.GetBillPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.mockito.Mockito.when;

//@Import({WireMockServerConfiguration.class, JacksonAutoConfiguration.class})
class BillServiceTest {

	@InjectMocks
	BillService billService;
	@Mock
	GetBillPort getStadisticPort;

	@BeforeEach
	void setup(){
		MockitoAnnotations.openMocks(this);
	}
	@Test
	void bills() {
		when(getStadisticPort.getBills()).thenReturn(List.of());
		billService.bills();
	}
}
