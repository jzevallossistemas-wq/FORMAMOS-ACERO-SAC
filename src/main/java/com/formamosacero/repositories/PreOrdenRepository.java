package com.formamosacero.repositories;

import com.formamosacero.models.PreOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PreOrdenRepository extends JpaRepository<PreOrden, Long>, JpaSpecificationExecutor<PreOrden> {
    
    Optional<PreOrden> findByNumero(String numero);
    
    List<PreOrden> findByEstado(String estado);
    
    List<PreOrden> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin);
    
    List<PreOrden> findBySolicitanteContainingIgnoreCase(String solicitante);
    
    List<PreOrden> findByArea(String area);
    
    List<PreOrden> findByClienteId(Long clienteId);
    
    List<PreOrden> findByProveedorId(Long proveedorId);
    
    @Query("SELECT p FROM PreOrden p WHERE p.fecha >= :fechaInicio AND p.fecha <= :fechaFin AND p.estado = :estado")
    List<PreOrden> findByFechaRangeAndEstado(@Param("fechaInicio") LocalDate fechaInicio, 
                                               @Param("fechaFin") LocalDate fechaFin, 
                                               @Param("estado") String estado);
}
