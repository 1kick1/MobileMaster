package com.example.mobilemaster.repository;

import com.example.mobilemaster.model.PedidoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoDetalleRepository extends JpaRepository<PedidoDetalle, Long> {
    public List<PedidoDetalle> getPedidoDetalleByPedidoIdPedido(Long pedido_id);
}