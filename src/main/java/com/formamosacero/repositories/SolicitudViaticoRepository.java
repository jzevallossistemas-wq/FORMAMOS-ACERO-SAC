package com.formamosacero.repositories;

import com.formamosacero.models.SolicitudViatico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface SolicitudViaticoRepository extends JpaRepository<SolicitudViatico, Long>, JpaSpecificationExecutor<SolicitudViatico> {
    
    Optional<SolicitudViatico> findByNumero(String numero);
    
    List<SolicitudViatico> findByEstado(String estado);
    
    List<SolicitudViatico> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin);
    
    List<SolicitudViatico> findBySolicitanteContainingIgnoreCase(String solicitante);
    
    List<SolicitudViatico> findByArea(String area);
    
    List<SolicitudViatico> findByClienteId(Long clienteId);
    
    List<SolicitudViatico> findByDestinoContainingIgnoreCase(String destino);
    
    @Query("SELECT s FROM SolicitudViatico s WHERE s.fecha >= :fechaInicio AND s.fecha <= :fechaFin AND s.estado = :estado")
    List<SolicitudViatico> findByFechaRangeAndEstado(@Param("fechaInicio") LocalDate fechaInicio, 
                                                       @Param("fechaFin") LocalDate fechaFin, 
                                                       @Param("estado") String estado);
}
