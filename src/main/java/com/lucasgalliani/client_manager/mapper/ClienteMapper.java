package com.lucasgalliani.client_manager.mapper;

import com.lucasgalliani.client_manager.dto.ClienteDto;
import com.lucasgalliani.client_manager.dto.ClienteResponseDto;
import com.lucasgalliani.client_manager.dto.EnderecoDto;
import com.lucasgalliani.client_manager.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public ClienteResponseDto toResponse(Cliente cliente) {

        EnderecoDto enderecoDto = new EnderecoDto(cliente.getEndereco().getLogradouro(),
                cliente.getEndereco().getNumero(), cliente.getEndereco().getTipoMoradia(), cliente.getEndereco().getBairro(),
                cliente.getEndereco().getEstado(), cliente.getEndereco().getCidade(), cliente.getEndereco().getCep());

        ClienteDto clienteDto = new ClienteDto(cliente.getNome(),cliente.getCpf(), cliente.getEmail(), cliente.getIdade(), cliente.getDataNascimento(), enderecoDto);

        return new ClienteResponseDto(clienteDto);
    }
}
