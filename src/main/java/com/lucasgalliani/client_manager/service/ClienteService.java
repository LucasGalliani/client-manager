package com.lucasgalliani.client_manager.service;

import com.lucasgalliani.client_manager.dto.ClienteDto;
import com.lucasgalliani.client_manager.dto.ClienteResponseDto;
import com.lucasgalliani.client_manager.infra.exception.CpfJaCadastradoException;
import com.lucasgalliani.client_manager.infra.exception.CpfNuloException;
import com.lucasgalliani.client_manager.mapper.ClienteMapper;
import com.lucasgalliani.client_manager.model.Cliente;
import com.lucasgalliani.client_manager.model.Endereco;
import com.lucasgalliani.client_manager.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Transactional
    public ClienteResponseDto cadastrarCliente(ClienteDto dto) {

        if (dto.cpf() == null || dto.cpf().trim().isEmpty()) {
            throw new CpfNuloException("CPF não pode ser vazio!");
        }

        if (clienteRepository.existsByCpf(dto.cpf())) {
            throw new CpfJaCadastradoException("CPF já cadastrado!");
        }

        Cliente cliente = new Cliente();
        cliente.setNome(dto.nome());
        cliente.setCpf(dto.cpf());
        cliente.setEmail(dto.email());
        cliente.setIdade(dto.idade());
        cliente.setAtivo(dto.ativo());
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

        Cliente save = clienteRepository.save(cliente);

        return clienteMapper.toResponse(save);
    }

    public List<ClienteResponseDto> listarTodosClientes() {

        return clienteRepository.findAllByAtivoTrue()
                .stream()
                .map(clienteMapper::toResponse)
                .collect(Collectors.toList());

    }

    public ClienteResponseDto listarPorCpf(String cpf) {

        Cliente cliente = clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new CpfNuloException("CPF não encontrado: " + cpf));

        return clienteMapper.toResponse(cliente);

    }

    public ClienteResponseDto atualizarCliente(String cpf, ClienteDto dto) {

        Cliente cliente = clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new CpfNuloException("CPF não encontrado: " + cpf));

        if (dto.nome() != null) {
            cliente.setNome(dto.nome());
        }

        if (dto.cpf() != null) {
            cliente.setCpf(dto.cpf());
        }

        if (dto.email() != null) {
            cliente.setEmail(dto.email());
        }

        if (dto.idade() != null) {
            cliente.setIdade(dto.idade());
        }

        if (dto.dataNascimento() != null) {
            cliente.setDataNascimento(dto.dataNascimento());
        }

        if (dto.ativo() != null) {
            cliente.setAtivo(dto.ativo());
        }

        if (dto.endereco() != null) {
            Endereco endereco = cliente.getEndereco();
            if (endereco == null) {
                endereco = new Endereco();
                cliente.setEndereco(endereco);
            }

            if (dto.endereco().logradouro() != null) {
                endereco.setLogradouro(dto.endereco().logradouro());
            }
            if (dto.endereco().numero() != null) {
                endereco.setNumero(dto.endereco().numero());
            }
            if (dto.endereco().bairro() != null) {
                endereco.setBairro(dto.endereco().bairro());
            }
            if (dto.endereco().estado() != null) {
                endereco.setEstado(dto.endereco().estado());
            }
            if (dto.endereco().cidade() != null) {
                endereco.setCidade(dto.endereco().cidade());
            }
            if (dto.endereco().cep() != null) {
                endereco.setCep(dto.endereco().cep());
            }

        }
        Cliente clienteAtualizado = clienteRepository.save(cliente);
        return clienteMapper.toResponse(clienteAtualizado);
    }

    public ClienteResponseDto deleteCadastroCliente(String cpf) {

        Cliente cliente = clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new CpfNuloException("CPF não encontrado: " + cpf));

        cliente.setAtivo(false);
        Cliente save = clienteRepository.save(cliente);

        return clienteMapper.toResponse(save);

    }
}