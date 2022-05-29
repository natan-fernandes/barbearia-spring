package com.natan.barbearia.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TiposServico {
    Corte("Corte", 15, "/icones/corte.svg"),
    Barba("Barba", 17, "/icones/barba.svg"),
    CorteBarba("Corte e barba", 25, "/icones/cortebarba.svg"),
    Desenho("Desenho", 30, "/icones/desenho.svg"),
    Luzes("Luzes", 70, "/icones/luzes.svg"),
    Alisamento("Alisamento", 50, "/icones/alisamento.svg"),
    Pintura("Pintura", 40, "/icones/pintura.svg");

    @Getter
    private final String nome;

    @Getter
    private final int preco;

    @Getter
    private final String iconeUrl;

    public int getValue() {
        return ordinal() + 1;
    }
}
