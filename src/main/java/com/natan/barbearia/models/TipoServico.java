package com.natan.barbearia.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "TiposServico")
@EqualsAndHashCode(callSuper = true)
public class TipoServico extends BaseEntity {
    public TipoServico() {
    }

    public TipoServico(String descricao, int preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    private String descricao;
    private int preco;
}
