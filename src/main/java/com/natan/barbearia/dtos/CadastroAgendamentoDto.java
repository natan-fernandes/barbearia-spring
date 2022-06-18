package com.natan.barbearia.dtos;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class CadastroAgendamentoDto {
    private long clienteId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataAgendamento;

    private String descricao;

    private long equipeId;
    private List<Long> servicosIds;
}
