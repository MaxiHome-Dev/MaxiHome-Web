package com.maxihome.maxihome.repository;

import com.maxihome.maxihome.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
    // Aquí puedes añadir consultas específicas si las necesitas, por ejemplo:
    // List<Proveedor> findByNombreContaining(String nombre);
}
