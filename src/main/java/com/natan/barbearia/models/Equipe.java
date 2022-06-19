package com.natan.barbearia.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Equipes")
@EqualsAndHashCode(callSuper = true)
public class Equipe extends BaseEntity {
    private String nome;
}
