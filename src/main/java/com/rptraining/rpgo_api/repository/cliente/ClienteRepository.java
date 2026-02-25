package com.rptraining.rpgo_api.repository.cliente;

import com.rptraining.rpgo_api.entity.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}