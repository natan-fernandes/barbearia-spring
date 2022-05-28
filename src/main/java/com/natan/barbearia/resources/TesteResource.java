package com.natan.barbearia.resources;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TesteResource {

//    private final ClienteService clienteService;
//
//    public TesteResource(ClienteService vendasService) {
//        this.clienteService = vendasService;
//    }
//
    @GetMapping
    public String Teste() {
        return "ok";
    }

//    @PostMapping("/cadastrar")
//    public Cliente cadastrarCliente(@RequestBody CadastroClienteDto cliente) {
//        return clienteService.cadastrarCliente(cliente);
//    }
}