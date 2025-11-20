package com.maxihome.maxihome.repository;

import com.maxihome.maxihome.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    /**
     * Devuelve todos los pedidos de un usuario dado su ID.
     */
    List<Order> findByUsuarioId(Long usuarioId);

    // Para listar todos en orden descendente por fecha
    List<Order> findAllByOrderByCreatedAtDesc();
}
