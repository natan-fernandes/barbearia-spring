package com.natan.barbearia.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TiposServico {
    Corte("Corte", 15),
    Barba("Barba", 17),
    CorteBarba("Corte e barba", 25),
    Desenho("Desenho", 30),
    Luzes("Luzes", 70),
    Alisamento("Alisamento", 50),
    Pintura("Pintura", 40);

    @Getter
    private final String nome;

    @Getter
    private final int preco;

    public int getValue() {
        return ordinal() + 1;
    }
}
