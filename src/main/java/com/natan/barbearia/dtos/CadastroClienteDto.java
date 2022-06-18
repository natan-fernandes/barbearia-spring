package com.natan.barbearia.dtos;

import lombok.Data;

@Data
public class CadastroClienteDto {
    private String nome;
    private String telefone;
    private int idade;
}
