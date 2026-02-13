package com.formamosacero.repositories;

import com.formamosacero.models.CotizacionPasajes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CotizacionPasajesRepository extends JpaRepository<CotizacionPasajes, Long> {
    CotizacionPasajes findByNumero(String numero);
    List<CotizacionPasajes> findByEstado(String estado);
    List<CotizacionPasajes> findByClienteId(Long clienteId);
    List<CotizacionPasajes> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin);
    List<CotizacionPasajes> findByNumeroContainingIgnoreCase(String numero);
    List<CotizacionPasajes> findByDestino(String destino);
}
