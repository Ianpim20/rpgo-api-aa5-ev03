package com.rptraining.rpgo_api.controller.rutina;

import com.rptraining.rpgo_api.entity.rutina.Rutina;
import com.rptraining.rpgo_api.service.rutina.RutinaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RutinaController {

    private final RutinaService rutinaService;

    public RutinaController(RutinaService rutinaService) {
        this.rutinaService = rutinaService;
    }

    @PostMapping("/clientes/{clienteId}/rutinas")
    public ResponseEntity<Rutina> crear(@PathVariable Long clienteId,
                                        @Valid @RequestBody Rutina rutina) {
        return new ResponseEntity<>(rutinaService.crear(clienteId, rutina), HttpStatus.CREATED);
    }

    @GetMapping("/clientes/{clienteId}/rutinas")
    public ResponseEntity<List<Rutina>> listar(@PathVariable Long clienteId) {
        return ResponseEntity.ok(rutinaService.listarPorCliente(clienteId));
    }

    @PutMapping("/rutinas/{id}")
    public ResponseEntity<Rutina> actualizar(@PathVariable Long id,
                                             @Valid @RequestBody Rutina rutina) {
        return ResponseEntity.ok(rutinaService.actualizar(id, rutina));
    }

    @DeleteMapping("/rutinas/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        rutinaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}