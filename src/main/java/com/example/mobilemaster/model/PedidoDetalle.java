package com.example.mobilemaster.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="tb_pedidoDetalle")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;

    @OneToOne()
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @Column(nullable = false)
    private Long cantidad;

    @Column(nullable = false)
    private BigDecimal preciovta;

    @Column(nullable = false)
    private BigDecimal importe;

    @ManyToOne()
    @JoinColumn(name = "id_pedido")//Campo "id_pedido???"
    private Pedido pedido;
}
