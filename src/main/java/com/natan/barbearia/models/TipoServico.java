package com.natan.barbearia.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "TiposServico")
@EqualsAndHashCode(callSuper = true)
public class TipoServico extends BaseEntity {
    public TipoServico() {
    }

    public TipoServico(String descricao, int preco, String iconeUrl) {
        this.descricao = descricao;
        this.preco = preco;
        this.iconeUrl = iconeUrl;
    }

    private String descricao;
    private int preco;
    private String iconeUrl;
}
