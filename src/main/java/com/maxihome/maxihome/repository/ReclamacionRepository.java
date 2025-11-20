package com.maxihome.maxihome.repository;

import com.maxihome.maxihome.model.Reclamacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamacionRepository extends JpaRepository<Reclamacion, Integer> {
}
