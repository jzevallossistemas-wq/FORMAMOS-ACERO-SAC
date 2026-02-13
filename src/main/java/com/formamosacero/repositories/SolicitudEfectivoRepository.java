package com.formamosacero.repositories;

import com.formamosacero.models.SolicitudEfectivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface SolicitudEfectivoRepository extends JpaRepository<SolicitudEfectivo, Long>, JpaSpecificationExecutor<SolicitudEfectivo> {
    
    Optional<SolicitudEfectivo> findByNumero(String numero);
    
    List<SolicitudEfectivo> findByEstado(String estado);
    
    List<SolicitudEfectivo> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin);
    
    List<SolicitudEfectivo> findBySolicitanteContainingIgnoreCase(String solicitante);
    
    List<SolicitudEfectivo> findByArea(String area);
    
    List<SolicitudEfectivo> findByClienteId(Long clienteId);
    
    @Query("SELECT s FROM SolicitudEfectivo s WHERE s.fecha >= :fechaInicio AND s.fecha <= :fechaFin AND s.estado = :estado")
    List<SolicitudEfectivo> findByFechaRangeAndEstado(@Param("fechaInicio") LocalDate fechaInicio, 
                                                        @Param("fechaFin") LocalDate fechaFin, 
                                                        @Param("estado") String estado);
}
