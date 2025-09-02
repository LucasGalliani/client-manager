package com.lucasgalliani.client_manager.repository;

import com.lucasgalliani.client_manager.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {



}
