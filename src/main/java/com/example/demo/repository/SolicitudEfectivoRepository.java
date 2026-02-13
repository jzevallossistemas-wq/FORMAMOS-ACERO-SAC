package com.example.demo.repository;

import com.example.demo.entity.SolicitudEfectivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SolicitudEfectivoRepository extends JpaRepository<SolicitudEfectivo, Long> {
    Optional<SolicitudEfectivo> findByNumero(String numero);
}
