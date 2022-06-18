package com.natan.barbearia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)

public class TipoServicoNotFoundException extends RuntimeException {
    public TipoServicoNotFoundException(String message) {
        super(message);
    }
}