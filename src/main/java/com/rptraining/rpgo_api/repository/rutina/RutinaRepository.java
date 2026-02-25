package com.rptraining.rpgo_api.repository.rutina;

import com.rptraining.rpgo_api.entity.rutina.Rutina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RutinaRepository extends JpaRepository<Rutina, Long> {
    List<Rutina> findByClienteId(Long clienteId);
}