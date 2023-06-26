package com.example.mobilemaster.service;

import com.example.mobilemaster.dtos.ProductoCreateDTO;
import com.example.mobilemaster.dtos.ProductoDTO;
import com.example.mobilemaster.dtos.ProductoUpdateDTO;
import com.example.mobilemaster.mappers.ProductoMapper;
import com.example.mobilemaster.model.Producto;
import com.example.mobilemaster.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicelmpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<ProductoDTO> listarProductos() {
        return ProductoMapper.instancia.listaProductoAListaProductoDTO( productoRepository.findAll());
    }

    @Override
    public ProductoDTO obtenerProductoPorID(long idProducto) {
        Optional<Producto> producto= productoRepository.findById(idProducto);
        ProductoDTO productoDTO ;
        if(producto.isPresent()){
            productoDTO = ProductoMapper.instancia.productoAProductoDTO(producto.get());
        }else {
            productoDTO=null;
        }
        return  productoDTO;
    }

    @Override
    public ProductoDTO registrarProducto(ProductoCreateDTO productoCreateDTO) {
        Producto producto= ProductoMapper.instancia.productoCreateDTOAProducto(productoCreateDTO);
        Producto respuestaEntity=productoRepository.save(producto);
        ProductoDTO respuestaDTO= ProductoMapper.instancia.productoAProductoDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public ProductoDTO actualizarProducto(ProductoUpdateDTO productoUpdateDTO) {
        Producto producto=ProductoMapper.instancia.productoUpdateDTOAProducto(productoUpdateDTO);
        Producto respuestaEntity=productoRepository.save(producto);
        ProductoDTO respuestaDTO= ProductoMapper.instancia.productoAProductoDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public ProductoDTO eliminarProducto(long idProducto) {
        Optional<Producto> productoOptional= productoRepository.findById(idProducto);
        ProductoDTO productoDTO = new ProductoDTO();
        String resultado ;
        if(productoOptional.isPresent()){
            productoDTO=ProductoMapper.instancia.productoAProductoDTO(productoOptional.get());
            productoRepository.delete(productoOptional.get());
            return productoDTO;
        }else {
            resultado="No se pudo eliminar";
        }
        return productoDTO;
    }
}
