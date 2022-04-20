package com.discodbank.Service;

import com.discodbank.Repository.ClienteRepository;
import com.discodbank.exception.UserNotFoundException;
import com.discodbank.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    public List<Cliente> findAllClientes() {

        return clienteRepository.findAll();
    }

    public Cliente addCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deleteClienteByCpf(Long cpf) {

        clienteRepository.deleteByCpf(cpf);
    }

    public Cliente findClienteByCpf(Long cpf) {

        return clienteRepository.findClienteByCpf().orElseThrow(() -> new UserNotFoundException("O cliente do " + cpf + "não foi encontrado"));
    }

}
