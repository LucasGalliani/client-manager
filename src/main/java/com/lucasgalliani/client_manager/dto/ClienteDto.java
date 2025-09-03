package com.lucasgalliani.client_manager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record ClienteDto(

        @NotBlank
        String nome,
        @NotBlank(message = "CPF não pode ser vazio")
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF deve seguir o formato XXX.XXX.XXX-XX")
        String cpf,
        String email,
        Integer idade,
        LocalDate dataNascimento,
        EnderecoDto endereco) {

}
