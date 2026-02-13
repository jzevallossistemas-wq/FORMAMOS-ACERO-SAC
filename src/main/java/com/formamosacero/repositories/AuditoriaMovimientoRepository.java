package com.formamosacero.repositories;

import com.formamosacero.models.AuditoriaMovimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AuditoriaMovimientoRepository extends JpaRepository<AuditoriaMovimiento, Long> {
    
    List<AuditoriaMovimiento> findByTipoModulo(String tipoModulo);
    
    List<AuditoriaMovimiento> findByNumeroSolicitud(String numeroSolicitud);
    
    List<AuditoriaMovimiento> findByUsuarioCreacion(String usuarioCreacion);
    
    List<AuditoriaMovimiento> findByAccion(String accion);
    
    @Query("SELECT a FROM AuditoriaMovimiento a WHERE a.tipoModulo = :tipoModulo AND a.numeroSolicitud = :numeroSolicitud ORDER BY a.fechaAccion DESC")
    List<AuditoriaMovimiento> findHistorialByModuloAndNumero(@Param("tipoModulo") String tipoModulo, 
                                                               @Param("numeroSolicitud") String numeroSolicitud);
    
    @Query("SELECT a FROM AuditoriaMovimiento a WHERE a.fechaAccion >= :fechaInicio AND a.fechaAccion <= :fechaFin ORDER BY a.fechaAccion DESC")
    List<AuditoriaMovimiento> findByFechaAccionBetween(@Param("fechaInicio") LocalDateTime fechaInicio, 
                                                         @Param("fechaFin") LocalDateTime fechaFin);
}
