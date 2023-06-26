package com.example.mobilemaster.service;

import com.example.mobilemaster.dtos.MarcaCreateDTO;
import com.example.mobilemaster.dtos.MarcaDTO;
import com.example.mobilemaster.dtos.MarcaUpdateDTO;
import com.example.mobilemaster.mappers.MarcaMapper;
import com.example.mobilemaster.model.Marca;
import com.example.mobilemaster.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaServicelmpl implements MarcaService{

    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public List<MarcaDTO> listarMarcas() {
        return MarcaMapper.instancia.listaMarcaAListaMarcaDTO( marcaRepository.findAll());
    }

    @Override
    public MarcaDTO obtenerMarcaPorID(long idMarca) {
        Optional<Marca> marca= marcaRepository.findById(idMarca);
        MarcaDTO marcaDTO ;
        if(marca.isPresent()){
            marcaDTO = MarcaMapper.instancia.marcaAMarcaDTO(marca.get());
        }else {
            marcaDTO=null;
        }
        return  marcaDTO;
    }

    @Override
    public MarcaDTO registrarMarca(MarcaCreateDTO marcaCreateDTO) {
        Marca marca= MarcaMapper.instancia.marcaCreateDTOAMarca(marcaCreateDTO);
        Marca respuestaEntity=marcaRepository.save(marca);
        MarcaDTO respuestaDTO= MarcaMapper.instancia.marcaAMarcaDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public MarcaDTO actualizarMarca(MarcaUpdateDTO marcaUpdateDTO) {
        Marca marca=MarcaMapper.instancia.marcaUpdateDTOAMarca(marcaUpdateDTO);
        Marca respuestaEntity=marcaRepository.save(marca);
        MarcaDTO respuestaDTO= MarcaMapper.instancia.marcaAMarcaDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public MarcaDTO eliminarMarca(long idMarca) {
        Optional<Marca> marcaOptional= marcaRepository.findById(idMarca);
        MarcaDTO marcaDTO = new MarcaDTO();
        String resultado ;
        if(marcaOptional.isPresent()){
            marcaDTO=MarcaMapper.instancia.marcaAMarcaDTO(marcaOptional.get());
            marcaRepository.delete(marcaOptional.get());
            return marcaDTO;
        }else {
            resultado="No se pudo eliminar";
        }
        return marcaDTO;
    }
}
