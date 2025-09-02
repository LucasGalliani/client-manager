package com.lucasgalliani.client_manager.infra.exception;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class CpfJaCadastradoException extends RuntimeException {

    public CpfJaCadastradoException(String message) {
        super(message);
    }
}
