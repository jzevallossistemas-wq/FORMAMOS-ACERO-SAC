package com.example.demo.repository;

import com.example.demo.entity.CotizacionPasajes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CotizacionPasajesRepository extends JpaRepository<CotizacionPasajes, Long> {
    Optional<CotizacionPasajes> findByNumero(String numero);
}
