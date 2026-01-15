package com.teslait.template.bill.application;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class CustomMetricService {

    private final Counter customCounter;

    public CustomMetricService(MeterRegistry meterRegistry) {
        // Registrar el contador personalizado
        this.customCounter = Counter.builder("custom.method.calls")
                .tag("method", "executeBusinessLogic")
                .description("Número de veces que se ejecuta el método executeBusinessLogic")
                .register(meterRegistry);
    }

    public void executeBusinessLogic() {

        // Incrementar el contador cada vez que se llama el método
        customCounter.increment();

        // Aquí va tu lógica de negocio
        System.out.println("Ejecutando lógica de negocio...");
    }
}
