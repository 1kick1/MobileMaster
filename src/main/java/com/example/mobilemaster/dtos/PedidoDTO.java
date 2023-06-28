package com.example.mobilemaster.dtos;

import com.example.mobilemaster.model.Cliente;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PedidoDTO {
    private Long idPedido;
    private Date fechaPedido;
    private Cliente cliente;
    private List<PedidoDetalleDTO> pedidoDetalleDTO;
}
