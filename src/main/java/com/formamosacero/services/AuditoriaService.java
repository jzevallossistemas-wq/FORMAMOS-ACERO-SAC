package com.formamosacero.services;

import com.formamosacero.models.AuditoriaMovimiento;
import com.formamosacero.repositories.AuditoriaMovimientoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AuditoriaService {

    private final AuditoriaMovimientoRepository auditoriaRepository;

    public void registrarAccion(String tipoModulo, String numeroSolicitud, String accion,
                                  String estadoAnterior, String estadoNuevo, String observacion,
                                  String usuario) {
        AuditoriaMovimiento auditoria = new AuditoriaMovimiento();
        auditoria.setTipoModulo(tipoModulo);
        auditoria.setNumeroSolicitud(numeroSolicitud);
        auditoria.setAccion(accion);
        auditoria.setEstadoAnterior(estadoAnterior);
        auditoria.setEstadoNuevo(estadoNuevo);
        auditoria.setObservacion(observacion);
        auditoria.setUsuarioCreacion(usuario);
        auditoria.setFechaAccion(LocalDateTime.now());
        
        auditoriaRepository.save(auditoria);
    }

    public List<AuditoriaMovimiento> findByTipoModulo(String tipoModulo) {
        return auditoriaRepository.findByTipoModulo(tipoModulo);
    }

    public List<AuditoriaMovimiento> findHistorial(String tipoModulo, String numeroSolicitud) {
        return auditoriaRepository.findHistorialByModuloAndNumero(tipoModulo, numeroSolicitud);
    }

    public List<AuditoriaMovimiento> findByFechaRange(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return auditoriaRepository.findByFechaAccionBetween(fechaInicio, fechaFin);
    }
}
