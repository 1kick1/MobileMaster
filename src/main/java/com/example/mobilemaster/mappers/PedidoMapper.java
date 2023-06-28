package com.example.mobilemaster.mappers;

import com.example.mobilemaster.dtos.PedidoDTO;
import com.example.mobilemaster.model.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PedidoMapper {
    PedidoMapper instancia= Mappers.getMapper(PedidoMapper.class);

    PedidoDTO pedidoAPedidoDTO(Pedido pedido);

    Pedido pedidoDTOAPedido(PedidoDTO pedidoDTO);

    List<PedidoDTO> listaPedidoAListaPedidoDTO (List<Pedido> listaPedido);

}
