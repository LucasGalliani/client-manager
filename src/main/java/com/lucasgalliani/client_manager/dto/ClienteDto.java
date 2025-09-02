package com.lucasgalliani.client_manager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record ClienteDto(
        @NotBlank
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{11}",
                message = "CPF inválido")
        String cpf,
        @NotBlank
        String nome,
        String email,
        Integer idade,
        LocalDate dataNascimento,
        EnderecoDto endereco) {

}
