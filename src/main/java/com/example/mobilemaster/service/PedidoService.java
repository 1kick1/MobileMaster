package com.example.mobilemaster.service;

import com.example.mobilemaster.dtos.PedidoDTO;

import java.util.List;

public interface PedidoService {
    List<PedidoDTO> listarPedidos();
    PedidoDTO obtenerPedidoPorID(Long id);
    PedidoDTO registrarPedido(PedidoDTO pedidoDTO);
}
