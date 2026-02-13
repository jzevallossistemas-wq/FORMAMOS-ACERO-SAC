package com.formamosacero.repositories;

import com.formamosacero.models.CotizacionPasajes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CotizacionPasajesRepository extends JpaRepository<CotizacionPasajes, Long>, JpaSpecificationExecutor<CotizacionPasajes> {
    
    Optional<CotizacionPasajes> findByNumero(String numero);
    
    List<CotizacionPasajes> findByEstado(String estado);
    
    List<CotizacionPasajes> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin);
    
    List<CotizacionPasajes> findBySolicitanteContainingIgnoreCase(String solicitante);
    
    List<CotizacionPasajes> findByClienteId(Long clienteId);
    
    List<CotizacionPasajes> findByDestinoContainingIgnoreCase(String destino);
    
    @Query("SELECT c FROM CotizacionPasajes c WHERE c.fecha >= :fechaInicio AND c.fecha <= :fechaFin AND c.estado = :estado")
    List<CotizacionPasajes> findByFechaRangeAndEstado(@Param("fechaInicio") LocalDate fechaInicio, 
                                                        @Param("fechaFin") LocalDate fechaFin, 
                                                        @Param("estado") String estado);
}
