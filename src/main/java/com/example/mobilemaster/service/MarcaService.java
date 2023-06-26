package com.example.mobilemaster.service;

import com.example.mobilemaster.dtos.*;

import java.util.List;

public interface MarcaService {
    List<MarcaDTO> listarMarcas();
    MarcaDTO obtenerMarcaPorID(long idMarca);
    MarcaDTO registrarMarca(MarcaCreateDTO marcaCreateDTO);
    MarcaDTO actualizarMarca(MarcaUpdateDTO marcaUpdateDTO);
    MarcaDTO eliminarMarca(long idMarca);
}
