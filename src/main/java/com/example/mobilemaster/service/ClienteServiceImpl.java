package com.example.mobilemaster.service;

import com.example.mobilemaster.dtos.ClienteCreateDTO;
import com.example.mobilemaster.dtos.ClienteDTO;
import com.example.mobilemaster.dtos.ClienteUpdateDTO;
import com.example.mobilemaster.mappers.ClienteMapper;
import com.example.mobilemaster.model.Cliente;
import com.example.mobilemaster.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> listarClientes() {

        List<Cliente> lista = clienteRepository.findAll();

        for (Cliente cli : lista) {
            System.out.println(" "+ cli.getIdCliente().toString() +" --> "+ cli.getFechaIngreso().toString());
        }

        return ClienteMapper.instancia.listaClienteAListaClienteDTO( clienteRepository.findAll());
    }

    @Override
    public ClienteDTO obtenerClientePorID(long id) {
        Optional<Cliente> producto= clienteRepository.findById(id);
        ClienteDTO clienteDTO ;
        if(producto.isPresent()){
            clienteDTO = ClienteMapper.instancia.clienteAClienteDTO(producto.get());
        }else {
            clienteDTO=null;
        }
        return  clienteDTO;
    }

    @Override
    public ClienteDTO registrarCliente(ClienteCreateDTO productoCreateDTO) {
        Cliente producto=ClienteMapper.instancia.clienteCreateDTOACliente(productoCreateDTO);
        Cliente respuestaEntity=clienteRepository.save(producto);
        ClienteDTO respuestaDTO= ClienteMapper.instancia.clienteAClienteDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public ClienteDTO actualizarCliente(ClienteUpdateDTO clienteUpdateDTO) {

        Cliente producto=ClienteMapper.instancia.clienteUpdateDTOACliente(clienteUpdateDTO);
        Cliente respuestaEntity=clienteRepository.save(producto);
        ClienteDTO respuestaDTO= ClienteMapper.instancia.clienteAClienteDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public ClienteDTO eliminarCliente(long id) {
        Optional<Cliente> productoOptional= clienteRepository.findById(id);
        ClienteDTO clienteDTO = new ClienteDTO();
        String resultado ;
        if(productoOptional.isPresent()){
            clienteDTO=ClienteMapper.instancia.clienteAClienteDTO(productoOptional.get());
            clienteRepository.delete(productoOptional.get());
            return clienteDTO;
        }else {
            return clienteDTO;
        }
    }
}

