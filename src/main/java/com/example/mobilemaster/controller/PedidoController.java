package com.example.mobilemaster.controller;

import com.example.mobilemaster.dtos.PedidoDTO;
import com.example.mobilemaster.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("pedidos")
    public ResponseEntity<List<PedidoDTO>> listarPedidos(){
        return   new ResponseEntity<>(pedidoService.listarPedidos(), HttpStatus.OK);
    }

    @GetMapping("/pedidos/{pedidoId}")
    public ResponseEntity<PedidoDTO> obtenerPedidoPorId(@PathVariable("pedidoId") long pedidoId){
        return  new ResponseEntity<> ( pedidoService.obtenerPedidoPorID(pedidoId),HttpStatus.OK);
    }

    @PostMapping("pedidos")
    public ResponseEntity<PedidoDTO> registrarPedido(@RequestBody PedidoDTO pedidoDTO){
        return  new ResponseEntity <>( pedidoService.registrarPedido(pedidoDTO) ,HttpStatus.OK) ;
    }

}
