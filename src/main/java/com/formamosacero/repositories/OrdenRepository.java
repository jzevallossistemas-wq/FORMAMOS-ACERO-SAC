package com.formamosacero.repositories;

import com.formamosacero.models.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long>, JpaSpecificationExecutor<Orden> {
    
    Optional<Orden> findByNumero(String numero);
    
    List<Orden> findByEstado(String estado);
    
    List<Orden> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin);
    
    List<Orden> findBySolicitanteContainingIgnoreCase(String solicitante);
    
    List<Orden> findByArea(String area);
    
    List<Orden> findByClienteId(Long clienteId);
    
    List<Orden> findByProveedorId(Long proveedorId);
    
    @Query("SELECT o FROM Orden o WHERE o.fecha >= :fechaInicio AND o.fecha <= :fechaFin AND o.estado = :estado")
    List<Orden> findByFechaRangeAndEstado(@Param("fechaInicio") LocalDate fechaInicio, 
                                           @Param("fechaFin") LocalDate fechaFin, 
                                           @Param("estado") String estado);
}
