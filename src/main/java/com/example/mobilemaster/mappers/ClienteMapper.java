package com.example.mobilemaster.mappers;

import com.example.mobilemaster.dtos.ClienteCreateDTO;
import com.example.mobilemaster.dtos.ClienteDTO;
import com.example.mobilemaster.dtos.ClienteUpdateDTO;
import com.example.mobilemaster.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClienteMapper {

    ClienteMapper instancia= Mappers.getMapper(ClienteMapper.class);

    ClienteDTO clienteAClienteDTO(Cliente cliente);
    Cliente clienteDTOACliente(ClienteDTO clienteDTO);
    Cliente clienteCreateDTOACliente(ClienteCreateDTO clienteCreateDTO);
    Cliente clienteUpdateDTOACliente(ClienteUpdateDTO clienteUpdateDTO);
    List<ClienteDTO> listaClienteAListaClienteDTO (List<Cliente> listaCliente);


}
