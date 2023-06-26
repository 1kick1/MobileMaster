package com.example.mobilemaster.mappers;

import com.example.mobilemaster.dtos.*;
import com.example.mobilemaster.model.Marca;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MarcaMapper {
    MarcaMapper instancia= Mappers.getMapper(MarcaMapper.class);

    MarcaDTO marcaAMarcaDTO(Marca marca);
    Marca marcaDTOAMarca(MarcaDTO marcaDTO);
    Marca marcaCreateDTOAMarca(MarcaCreateDTO marcaCreateDTO);
    Marca marcaUpdateDTOAMarca(MarcaUpdateDTO marcaUpdateDTO);
    List<MarcaDTO> listaMarcaAListaMarcaDTO (List<Marca> listaMarca);
}
