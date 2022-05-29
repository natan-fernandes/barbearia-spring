package com.natan.barbearia.dtos;

import lombok.Data;

@Data
public class TipoServicoDto {
    private long id;
    private String descricao;
    private int preco;
    private String iconeUrl;
}
