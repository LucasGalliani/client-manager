package com.lucasgalliani.client_manager.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class CpfNuloException extends RuntimeException {

    public CpfNuloException(String message) {
        super(message);
    }

}
