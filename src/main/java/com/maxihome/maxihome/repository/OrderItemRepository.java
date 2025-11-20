package com.maxihome.maxihome.repository;

import com.maxihome.maxihome.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    // No son necesarios métodos adicionales por el momento
}
