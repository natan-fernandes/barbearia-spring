package com.natan.barbearia.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Agendamentos")
@EqualsAndHashCode(callSuper = true)
public class Agendamento extends BaseEntity {
    @ManyToOne()
    private Equipe equipe;

    private String cliente;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataAgendamento;

    private String descricao;
    private boolean concluido;

    @ManyToMany
    private List<TipoServico> tiposServico;
}
