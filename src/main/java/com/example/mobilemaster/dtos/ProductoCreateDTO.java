package com.example.mobilemaster.dtos;

import com.example.mobilemaster.model.Marca;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductoCreateDTO {
    private Marca marca;
    private String descripcion;
    private Integer stock;
    private BigDecimal precio;
}
