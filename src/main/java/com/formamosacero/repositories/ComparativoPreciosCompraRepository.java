package com.formamosacero.repositories;

import com.formamosacero.models.ComparativoPreciosCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ComparativoPreciosCompraRepository extends JpaRepository<ComparativoPreciosCompra, Long>, JpaSpecificationExecutor<ComparativoPreciosCompra> {
    
    Optional<ComparativoPreciosCompra> findByNumero(String numero);
    
    List<ComparativoPreciosCompra> findByEstado(String estado);
    
    List<ComparativoPreciosCompra> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin);
    
    List<ComparativoPreciosCompra> findBySolicitanteContainingIgnoreCase(String solicitante);
    
    List<ComparativoPreciosCompra> findByClienteId(Long clienteId);
    
    @Query("SELECT c FROM ComparativoPreciosCompra c WHERE c.fecha >= :fechaInicio AND c.fecha <= :fechaFin AND c.estado = :estado")
    List<ComparativoPreciosCompra> findByFechaRangeAndEstado(@Param("fechaInicio") LocalDate fechaInicio, 
                                                               @Param("fechaFin") LocalDate fechaFin, 
                                                               @Param("estado") String estado);
}
