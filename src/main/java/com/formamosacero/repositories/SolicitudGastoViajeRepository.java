package com.formamosacero.repositories;

import com.formamosacero.models.SolicitudGastoViaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface SolicitudGastoViajeRepository extends JpaRepository<SolicitudGastoViaje, Long>, JpaSpecificationExecutor<SolicitudGastoViaje> {
    
    Optional<SolicitudGastoViaje> findByNumero(String numero);
    
    List<SolicitudGastoViaje> findByEstado(String estado);
    
    List<SolicitudGastoViaje> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin);
    
    List<SolicitudGastoViaje> findBySolicitanteContainingIgnoreCase(String solicitante);
    
    List<SolicitudGastoViaje> findByArea(String area);
    
    List<SolicitudGastoViaje> findByClienteId(Long clienteId);
    
    List<SolicitudGastoViaje> findByDestinoContainingIgnoreCase(String destino);
    
    @Query("SELECT s FROM SolicitudGastoViaje s WHERE s.fecha >= :fechaInicio AND s.fecha <= :fechaFin AND s.estado = :estado")
    List<SolicitudGastoViaje> findByFechaRangeAndEstado(@Param("fechaInicio") LocalDate fechaInicio, 
                                                          @Param("fechaFin") LocalDate fechaFin, 
                                                          @Param("estado") String estado);
}
