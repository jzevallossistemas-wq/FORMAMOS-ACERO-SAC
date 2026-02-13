package com.formamosacero.repositories;

import com.formamosacero.models.ComparativoPreciosPasajes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ComparativoPreciosPasajesRepository extends JpaRepository<ComparativoPreciosPasajes, Long>, JpaSpecificationExecutor<ComparativoPreciosPasajes> {
    
    Optional<ComparativoPreciosPasajes> findByNumero(String numero);
    
    List<ComparativoPreciosPasajes> findByEstado(String estado);
    
    List<ComparativoPreciosPasajes> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin);
    
    List<ComparativoPreciosPasajes> findBySolicitanteContainingIgnoreCase(String solicitante);
    
    List<ComparativoPreciosPasajes> findByClienteId(Long clienteId);
    
    List<ComparativoPreciosPasajes> findByDestinoContainingIgnoreCase(String destino);
    
    @Query("SELECT c FROM ComparativoPreciosPasajes c WHERE c.fecha >= :fechaInicio AND c.fecha <= :fechaFin AND c.estado = :estado")
    List<ComparativoPreciosPasajes> findByFechaRangeAndEstado(@Param("fechaInicio") LocalDate fechaInicio, 
                                                                @Param("fechaFin") LocalDate fechaFin, 
                                                                @Param("estado") String estado);
}
