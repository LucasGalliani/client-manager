package com.lucasgalliani.client_manager.dto;

import com.lucasgalliani.client_manager.enums.TipoMoradia;

public record EnderecoDto(String logradouro,
                          String numero,
                          TipoMoradia tipoMoradia,
                          String bairro,
                          String estado,
                          String cidade,
                          String cep) {
}
