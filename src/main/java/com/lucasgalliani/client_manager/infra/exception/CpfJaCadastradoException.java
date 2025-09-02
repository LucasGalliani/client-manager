package com.lucasgalliani.client_manager.infra.exception;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class CpfJaCadastradoException extends RuntimeException {

    public CpfJaCadastradoException(@NotBlank @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{11}",
            message = "CPF inválido") String s) {
    }
}
