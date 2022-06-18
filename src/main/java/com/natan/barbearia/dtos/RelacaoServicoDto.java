package com.natan.barbearia.dtos;

import com.natan.barbearia.models.TipoServico;
import lombok.Data;

@Data
public class RelacaoServicoDto {
    private String tipoServico;
    private double porcentagem;
}
