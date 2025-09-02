package com.lucasgalliani.client_manager.service;

import com.lucasgalliani.client_manager.dto.ClienteDto;
import com.lucasgalliani.client_manager.dto.ClienteResponseDto;
import com.lucasgalliani.client_manager.mapper.ClienteMapper;
import com.lucasgalliani.client_manager.model.Cliente;
import com.lucasgalliani.client_manager.model.Endereco;
import com.lucasgalliani.client_manager.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Transactional
    public ClienteResponseDto cadastrarCliente(ClienteDto dto) {


        Cliente cliente = new Cliente();
        cliente.setCpf(dto.cpf());
        cliente.setEmail(dto.email());
        cliente.setIdade(dto.idade());
        cliente.setDataNascimento(dto.dataNascimento());

        Endereco endereco = new Endereco();
        endereco.setLogradouro(dto.endereco().logradouro());
        endereco.setNumero(dto.endereco().numero());
        endereco.setTipoMoradia(dto.endereco().tipoMoradia());
        endereco.setBairro(dto.endereco().bairro());
        endereco.setEstado(dto.endereco().estado());
        endereco.setCidade(dto.endereco().cidade());
        endereco.setCep(dto.endereco().cep());

        cliente.setEndereco(endereco);

        Cliente saved = clienteRepository.save(cliente);

        return clienteMapper.toResponse(saved);
    }
}
