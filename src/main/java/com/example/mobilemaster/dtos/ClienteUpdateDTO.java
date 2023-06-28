package com.example.mobilemaster.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ClienteUpdateDTO {

    private Long idCliente;
    private String dni;
    private String nombres;
    private String apePaterno;
    private String apeMaterno;
    private Date fechaIngreso;
    private String email;
}
