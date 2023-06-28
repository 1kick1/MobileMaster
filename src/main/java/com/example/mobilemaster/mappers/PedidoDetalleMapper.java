package com.example.mobilemaster.mappers;

import com.example.mobilemaster.dtos.PedidoDetalleDTO;
import com.example.mobilemaster.model.PedidoDetalle;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PedidoDetalleMapper {
    PedidoDetalleMapper instancia= Mappers.getMapper(PedidoDetalleMapper.class);

    PedidoDetalleDTO pedidoDetalleAPedidoDetalleDTO(PedidoDetalle pedidoDetalle);

    PedidoDetalle pedidoDetalleDTOAPedidoDetalle(PedidoDetalleDTO pedidoDetalleDTO);

    List<PedidoDetalleDTO> listaPedidoDetalleAListaPedidoDetalleDTO (List<PedidoDetalle> listaPedidoDetalle);

    List<PedidoDetalle> listaPedidoDetalleDTOAListaPedidoDetalle (List<PedidoDetalleDTO> listaPedidoDetalleDTO);

}
