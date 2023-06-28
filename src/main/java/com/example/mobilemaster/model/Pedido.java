package com.example.mobilemaster.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="tb_pedido")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;//Campo "id" clase "Pedido"

    @Column(name="fechaPedido", nullable = false)
    @Temporal(value=TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yy")
    private Date fechaPedido;

    @OneToOne()
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido")
    private List<PedidoDetalle> pedidoDetalle;
}
