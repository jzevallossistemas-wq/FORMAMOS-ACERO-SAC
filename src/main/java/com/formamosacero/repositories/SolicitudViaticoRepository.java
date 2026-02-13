package com.formamosacero.repositories;

import com.formamosacero.models.SolicitudViatico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SolicitudViaticoRepository extends JpaRepository<SolicitudViatico, Long> {
    SolicitudViatico findByNumero(String numero);
    List<SolicitudViatico> findByEstado(String estado);
    List<SolicitudViatico> findByClienteId(Long clienteId);
    List<SolicitudViatico> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin);
    List<SolicitudViatico> findByNumeroContainingIgnoreCase(String numero);
    List<SolicitudViatico> findByDestino(String destino);
}
