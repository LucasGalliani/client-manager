package com.lucasgalliani.client_manager.model;

import com.lucasgalliani.client_manager.enums.TipoMoradia;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String numero;
    @Enumerated(EnumType.STRING)
    private TipoMoradia tipoMoradia;
    private String bairro;
    private String estado;
    private String cidade;
    private String cep;
}
