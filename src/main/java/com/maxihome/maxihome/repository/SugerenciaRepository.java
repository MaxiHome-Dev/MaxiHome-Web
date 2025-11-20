package com.maxihome.maxihome.repository;

import com.maxihome.maxihome.model.Sugerencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SugerenciaRepository extends JpaRepository<Sugerencia, Integer> {
    // aquí podrías añadir consultas personalizadas si luego las necesitas
}
