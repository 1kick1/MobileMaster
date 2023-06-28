package com.example.mobilemaster.dtos;

import com.example.mobilemaster.model.Producto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PedidoDetalleDTO {

    private Long idDetalle;
    private Producto producto;
    private Long cantidad;
    private BigDecimal preciovta;
    private BigDecimal importe;
}
