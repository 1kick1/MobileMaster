package com.example.mobilemaster.mappers;

import com.example.mobilemaster.dtos.ProductoCreateDTO;
import com.example.mobilemaster.dtos.ProductoDTO;
import com.example.mobilemaster.dtos.ProductoUpdateDTO;
import com.example.mobilemaster.model.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductoMapper {
    ProductoMapper instancia= Mappers.getMapper(ProductoMapper.class);

    ProductoDTO productoAProductoDTO(Producto producto);
    Producto productoDTOAProducto(ProductoDTO productoDTO);
    Producto productoCreateDTOAProducto(ProductoCreateDTO productoCreateDTO);
    Producto productoUpdateDTOAProducto(ProductoUpdateDTO productoUpdateDTO);
    List<ProductoDTO> listaProductoAListaProductoDTO (List<Producto> listaProducto);
}
