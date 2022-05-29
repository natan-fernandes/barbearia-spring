package com.natan.barbearia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)

public class TipoServicoNotFound extends RuntimeException {
    public TipoServicoNotFound(String message) {
        super(message);
    }
}