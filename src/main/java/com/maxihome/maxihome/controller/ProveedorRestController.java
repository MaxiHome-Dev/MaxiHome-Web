package com.maxihome.maxihome.controller;

import com.maxihome.maxihome.model.Proveedor;
import com.maxihome.maxihome.repository.ProveedorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api/proveedores")
@PreAuthorize("hasRole('ADMIN')")
public class ProveedorRestController {

    private final ProveedorRepository repo;

    public ProveedorRestController(ProveedorRepository repo) {
        this.repo = repo;
    }

    // 1. Listar todos
    @GetMapping
    public List<Proveedor> listarTodos() {
        return repo.findAll();
    }

    // 2. Obtener uno por ID
    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> obtenerPorId(@PathVariable Integer id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. Crear uno nuevo
    @PostMapping
    public Proveedor crear(@RequestBody Proveedor proveedor) {
        return repo.save(proveedor);
    }

    // 4. Actualizar uno existente
    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> actualizar(
            @PathVariable Integer id,
            @RequestBody Proveedor datos) {
        return repo.findById(id)
                .map(existing -> {
                    existing.setNombre(datos.getNombre());
                    existing.setTelefono(datos.getTelefono());
                    existing.setEmail(datos.getEmail());
                    existing.setDireccion(datos.getDireccion());
                    return ResponseEntity.ok(repo.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 5. Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Integer id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
