package com.rptraining.rpgo_api.service.cliente;

import com.rptraining.rpgo_api.entity.cliente.Cliente;
import com.rptraining.rpgo_api.exception.ResourceNotFoundException;
import com.rptraining.rpgo_api.repository.cliente.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente crear(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    public Cliente obtenerPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id: " + id));
    }

    public Cliente actualizar(Long id, Cliente datos) {
        Cliente existente = obtenerPorId(id);
        existente.setNombre(datos.getNombre());
        existente.setTelefono(datos.getTelefono());
        existente.setEmail(datos.getEmail());
        return clienteRepository.save(existente);
    }

    public void eliminar(Long id) {
        Cliente existente = obtenerPorId(id);
        clienteRepository.delete(existente);
    }
}