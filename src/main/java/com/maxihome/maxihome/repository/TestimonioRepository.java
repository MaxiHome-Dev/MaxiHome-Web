package com.maxihome.maxihome.repository;

import com.maxihome.maxihome.model.Testimonio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestimonioRepository extends JpaRepository<Testimonio, Integer> {
    // puedes añadir aquí búsquedas por fecha, etc.
}
