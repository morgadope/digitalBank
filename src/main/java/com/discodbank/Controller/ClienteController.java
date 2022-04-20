package com.discodbank.Controller;


import com.discodbank.Service.ClienteService;
import com.discodbank.model.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;


    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cliente>> getAllClientes() {

        List<Cliente> clientes = clienteService.findAllClientes();

        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/find/{cpf}")
    public ResponseEntity<Cliente> getAllClientesByCpf(@PathVariable("cpf") Long cpf) {

        Cliente cliente = clienteService.findClienteByCpf(cpf);

        return new ResponseEntity<>(cliente, HttpStatus.OK);

    }
    @PostMapping("/add")
    public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) {

        Cliente novoCliente = clienteService.addCliente(cliente);

        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

}
