package com.lucasgalliani.client_manager.infra.exception;

import com.lucasgalliani.client_manager.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(CpfNuloException.class)
    public ResponseEntity<ExceptionDto> cpfNotNull(CpfNuloException ex) {
        ExceptionDto exceptionDto = new ExceptionDto("CPF não pode ser nulo ou vazio!", "400");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }

    @ExceptionHandler(CpfJaCadastradoException.class)
    public ResponseEntity<ExceptionDto> duplicatedCpf(CpfJaCadastradoException ex) {
        ExceptionDto exceptionDto = new ExceptionDto("CPF já cadastrado!", "400");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDto> handleValidationErrors(MethodArgumentNotValidException ex) {

        ExceptionDto exceptionDto = new ExceptionDto("Valor inválido para o CPF!", "400");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }

}
