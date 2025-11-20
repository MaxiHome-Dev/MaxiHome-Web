package com.maxihome.maxihome.repository;

import com.maxihome.maxihome.model.CategoriaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaProductoRepository extends JpaRepository<CategoriaProducto, Integer> {
    // Puedes añadir métodos personalizados si lo necesitas
}
