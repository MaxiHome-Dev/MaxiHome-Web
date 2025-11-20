package com.maxihome.maxihome.repository;

import com.maxihome.maxihome.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Integer> {
}
