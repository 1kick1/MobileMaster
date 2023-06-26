package com.example.mobilemaster.service;

import com.example.mobilemaster.dtos.ProductoCreateDTO;
import com.example.mobilemaster.dtos.ProductoDTO;
import com.example.mobilemaster.dtos.ProductoUpdateDTO;

import java.util.List;

public interface ProductoService {
    List<ProductoDTO> listarProductos();
    ProductoDTO obtenerProductoPorID(long idProducto);
    ProductoDTO registrarProducto(ProductoCreateDTO productoCreateDTO);
    ProductoDTO actualizarProducto(ProductoUpdateDTO productoUpdateDTO);
    ProductoDTO eliminarProducto(long idProducto);
}
