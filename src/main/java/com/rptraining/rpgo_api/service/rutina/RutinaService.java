package com.rptraining.rpgo_api.service.rutina;

import com.rptraining.rpgo_api.entity.cliente.Cliente;
import com.rptraining.rpgo_api.entity.rutina.Rutina;
import com.rptraining.rpgo_api.exception.ResourceNotFoundException;
import com.rptraining.rpgo_api.repository.cliente.ClienteRepository;
import com.rptraining.rpgo_api.repository.rutina.RutinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutinaService {

    private final RutinaRepository rutinaRepository;
    private final ClienteRepository clienteRepository;

    public RutinaService(RutinaRepository rutinaRepository,
                         ClienteRepository clienteRepository) {
        this.rutinaRepository = rutinaRepository;
        this.clienteRepository = clienteRepository;
    }

    public Rutina crear(Long clienteId, Rutina rutina) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id: " + clienteId));

        rutina.setCliente(cliente);
        return rutinaRepository.save(rutina);
    }

    public List<Rutina> listarPorCliente(Long clienteId) {
        return rutinaRepository.findByClienteId(clienteId);
    }

    public Rutina actualizar(Long id, Rutina datos) {
        Rutina existente = rutinaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rutina no encontrada con id: " + id));

        existente.setNombre(datos.getNombre());
        existente.setDescripcion(datos.getDescripcion());

        return rutinaRepository.save(existente);
    }

    public void eliminar(Long id) {
        Rutina existente = rutinaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rutina no encontrada con id: " + id));

        rutinaRepository.delete(existente);
    }
}