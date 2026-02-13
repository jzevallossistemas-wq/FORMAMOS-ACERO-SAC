package com.formamosacero.repositories;

import com.formamosacero.models.SolicitudEfectivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SolicitudEfectivoRepository extends JpaRepository<SolicitudEfectivo, Long> {
    SolicitudEfectivo findByNumero(String numero);
    List<SolicitudEfectivo> findByEstado(String estado);
    List<SolicitudEfectivo> findByClienteId(Long clienteId);
    List<SolicitudEfectivo> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin);
    List<SolicitudEfectivo> findByNumeroContainingIgnoreCase(String numero);
}
