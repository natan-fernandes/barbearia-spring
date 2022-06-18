package com.natan.barbearia.resources;

import com.natan.barbearia.dtos.CadastroClienteDto;
import com.natan.barbearia.exceptions.ClienteNotFoundException;
import com.natan.barbearia.models.Cliente;
import com.natan.barbearia.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/cliente")
public class ClienteResource {
    private final ClienteService clienteService;

    public ClienteResource(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Cliente> cadastrar(@RequestBody CadastroClienteDto cadastroClienteDto) {
        return ResponseEntity.ok(clienteService.cadastrar(cadastroClienteDto));
    }

    @GetMapping("/{id}")
    public Cliente obterPorId(@PathVariable long id)
            throws ClienteNotFoundException {
        return clienteService.obterPorId(id);
    }
}
