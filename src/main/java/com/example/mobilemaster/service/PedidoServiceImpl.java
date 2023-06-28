package com.example.mobilemaster.service;

import com.example.mobilemaster.dtos.PedidoDTO;
import com.example.mobilemaster.dtos.PedidoDetalleDTO;
import com.example.mobilemaster.mappers.PedidoDetalleMapper;
import com.example.mobilemaster.mappers.PedidoMapper;
import com.example.mobilemaster.model.Pedido;
import com.example.mobilemaster.model.PedidoDetalle;
import com.example.mobilemaster.repository.PedidoDetalleRepository;
import com.example.mobilemaster.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoDetalleRepository pedidoDetalleRepository;

    @Override
    public List<PedidoDTO> listarPedidos() {
        List<PedidoDTO> lista= PedidoMapper.instancia.listaPedidoAListaPedidoDTO(pedidoRepository.findAll());
        for(int x=0; x<lista.size();x++){
            lista.get(x).setPedidoDetalleDTO(
                    PedidoDetalleMapper.instancia.listaPedidoDetalleAListaPedidoDetalleDTO(pedidoDetalleRepository.getPedidoDetalleByPedidoIdPedido(lista.get(x).getIdPedido()))
            );
        }
        return lista;
    }

    @Override
    public PedidoDTO obtenerPedidoPorID(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        PedidoDTO pedidoDTO;
        if(pedido.isPresent()){
            pedidoDTO=PedidoMapper.instancia.pedidoAPedidoDTO(pedido.get());
            pedidoDTO.setPedidoDetalleDTO(
                    PedidoDetalleMapper.instancia.listaPedidoDetalleAListaPedidoDetalleDTO(pedidoDetalleRepository.getPedidoDetalleByPedidoIdPedido(pedido.get().getIdPedido()))
            );
        }else {
            pedidoDTO=null;
        }
        return pedidoDTO;
    }

    @Override
    @Transactional
    public PedidoDTO registrarPedido(PedidoDTO pedidoDTO) {
        Pedido pedido=PedidoMapper.instancia.pedidoDTOAPedido(pedidoDTO);
        Pedido respuestaEntity=pedidoRepository.save(pedido);

        for(PedidoDetalleDTO pedDetalleDTO : pedidoDTO.getPedidoDetalleDTO()){
            PedidoDetalle pd=PedidoDetalleMapper.instancia.pedidoDetalleDTOAPedidoDetalle(pedDetalleDTO);
            pd.setPedido(respuestaEntity);
            pedidoDetalleRepository.save(pd);
        }

        PedidoDTO respuestaDTO=PedidoMapper.instancia.pedidoAPedidoDTO(pedidoRepository.getById(respuestaEntity.getIdPedido()));
        respuestaDTO.setPedidoDetalleDTO(
                PedidoDetalleMapper.instancia.listaPedidoDetalleAListaPedidoDetalleDTO(pedidoDetalleRepository.getPedidoDetalleByPedidoIdPedido(respuestaEntity.getIdPedido()))
        );
        return respuestaDTO;
    }
}

