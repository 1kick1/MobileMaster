package com.example.mobilemaster.service;

import com.example.mobilemaster.dtos.ClienteCreateDTO;
import com.example.mobilemaster.dtos.ClienteDTO;
import com.example.mobilemaster.dtos.ClienteUpdateDTO;

import java.util.List;

public interface ClienteService {

    List<ClienteDTO> listarClientes();
    ClienteDTO obtenerClientePorID(long id);
    ClienteDTO registrarCliente(ClienteCreateDTO clienteCreateDTO);
    ClienteDTO actualizarCliente(ClienteUpdateDTO clienteUpdateDTO);
    ClienteDTO eliminarCliente(long id);

}
