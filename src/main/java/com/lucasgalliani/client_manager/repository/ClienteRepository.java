package com.lucasgalliani.client_manager.repository;

import com.lucasgalliani.client_manager.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    boolean existsByCpf(String cpf);

    Optional<Cliente> findByCpf(String cpf);
    List<Cliente> findAllByAtivoTrue();
}
