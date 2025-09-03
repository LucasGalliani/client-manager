package com.lucasgalliani.client_manager.controller;


import com.lucasgalliani.client_manager.dto.ClienteDto;
import com.lucasgalliani.client_manager.dto.ClienteResponseDto;
import com.lucasgalliani.client_manager.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cadastrar")
    public ResponseEntity<ClienteResponseDto> cadastrarClientes(@RequestBody @Valid ClienteDto clienteDto) {
        return ResponseEntity.ok(clienteService.cadastrarCliente(clienteDto));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ClienteResponseDto>> obterTodosOsClientes() {
        return ResponseEntity.ok(clienteService.listarTodosClientes());
    }

    @GetMapping("/listar/{cpf}")
    public ResponseEntity<ClienteResponseDto> obterTodosOsClientesPorCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(clienteService.listarPorCpf(cpf));
    }

    @PutMapping("/atualizar/{cpf}")
    public ResponseEntity<ClienteResponseDto> atualizarCadastroClientePorCpf(@PathVariable String cpf, @RequestBody ClienteDto dto) {

        ClienteResponseDto response = clienteService.atualizarCliente(cpf, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/deletar/{cpf}")
    public ResponseEntity<ClienteResponseDto> deletarCadastroClientePorCpf(@PathVariable String cpf) {
        clienteService.deleteCadastroCliente(cpf);
        return ResponseEntity.noContent().build();
    }
}
