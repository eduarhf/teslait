package com.teslait.template.bill.infrastructure.outbound.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class Factura {
    private String nombreCliente;
    private String numeroFactura;
    private String pais;
    private String montoFactura;
    private String fechaFactura;
    private String fechaVencimiento;
}
