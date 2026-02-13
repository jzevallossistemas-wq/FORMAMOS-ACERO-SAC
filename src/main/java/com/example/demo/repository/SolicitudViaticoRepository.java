package com.example.demo.repository;

import com.example.demo.entity.SolicitudViatico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SolicitudViaticoRepository extends JpaRepository<SolicitudViatico, Long> {
    Optional<SolicitudViatico> findByNumero(String numero);
}
