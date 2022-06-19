package com.natan.barbearia.dtos;

import lombok.Data;

@Data
public class AuthRequestDto {
    private String email;
    private String senha;
}
