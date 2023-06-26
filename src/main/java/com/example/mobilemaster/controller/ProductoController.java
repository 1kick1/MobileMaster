package com.example.mobilemaster.controller;

import com.example.mobilemaster.dtos.ProductoCreateDTO;
import com.example.mobilemaster.dtos.ProductoDTO;
import com.example.mobilemaster.dtos.ProductoUpdateDTO;
import com.example.mobilemaster.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping("productos")
    public ResponseEntity<List<ProductoDTO>> listarProductos(){
        return new ResponseEntity<>(productoService.listarProductos(), HttpStatus.OK);
    }

    @GetMapping("/productos/{productoId}")
    public ResponseEntity<ProductoDTO> obtenerProductoPorId(@PathVariable("productoId") long productoId){
        return new ResponseEntity<> ( productoService.obtenerProductoPorID(productoId),HttpStatus.OK);
    }

    @PostMapping("productos")
    public ResponseEntity<ProductoDTO> registrarProducto(@RequestBody ProductoCreateDTO productoCreateDTO){
        return  new ResponseEntity <>( productoService.registrarProducto(productoCreateDTO) ,HttpStatus.OK) ;
    }

    @PutMapping("productos")
    public ResponseEntity<ProductoDTO> actualizarProducto(@RequestBody ProductoUpdateDTO productoUpdateDTO){
        return new ResponseEntity<>(productoService.actualizarProducto(productoUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/productos/{productoId}")
    public ResponseEntity<ProductoDTO> eliminarProducto(@PathVariable("productoId") long productoId) {
        return new ResponseEntity<>( productoService.eliminarProducto(productoId),HttpStatus.OK);
    }
}

