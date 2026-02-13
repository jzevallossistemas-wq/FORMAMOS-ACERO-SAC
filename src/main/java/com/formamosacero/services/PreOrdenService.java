package com.formamosacero.services;

import com.formamosacero.models.PreOrden;
import com.formamosacero.repositories.PreOrdenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PreOrdenService {

    private final PreOrdenRepository preOrdenRepository;
    private final AuditoriaService auditoriaService;

    public List<PreOrden> findAll() {
        return preOrdenRepository.findAll();
    }

    public Page<PreOrden> findAll(Pageable pageable) {
        return preOrdenRepository.findAll(pageable);
    }

    public Optional<PreOrden> findById(Long id) {
        return preOrdenRepository.findById(id);
    }

    public Optional<PreOrden> findByNumero(String numero) {
        return preOrdenRepository.findByNumero(numero);
    }

    public List<PreOrden> findByEstado(String estado) {
        return preOrdenRepository.findByEstado(estado);
    }

    public List<PreOrden> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin) {
        return preOrdenRepository.findByFechaBetween(fechaInicio, fechaFin);
    }

    public List<PreOrden> findBySolicitante(String solicitante) {
        return preOrdenRepository.findBySolicitanteContainingIgnoreCase(solicitante);
    }

    public PreOrden save(PreOrden preOrden) {
        PreOrden saved = preOrdenRepository.save(preOrden);
        auditoriaService.registrarAccion("PREORDEN", saved.getNumero(), "CREAR", 
                                          null, saved.getEstado(), "PreOrden creada", 
                                          preOrden.getUsuarioCreacion());
        return saved;
    }

    public PreOrden update(Long id, PreOrden preOrdenDetails) {
        return preOrdenRepository.findById(id)
                .map(preOrden -> {
                    String estadoAnterior = preOrden.getEstado();
                    
                    preOrden.setFecha(preOrdenDetails.getFecha());
                    preOrden.setCliente(preOrdenDetails.getCliente());
                    preOrden.setProveedor(preOrdenDetails.getProveedor());
                    preOrden.setSolicitante(preOrdenDetails.getSolicitante());
                    preOrden.setArea(preOrdenDetails.getArea());
                    preOrden.setConcepto(preOrdenDetails.getConcepto());
                    preOrden.setMonto(preOrdenDetails.getMonto());
                    preOrden.setMoneda(preOrdenDetails.getMoneda());
                    preOrden.setEstado(preOrdenDetails.getEstado());
                    preOrden.setVbGerencia(preOrdenDetails.getVbGerencia());
                    preOrden.setAutorizacion(preOrdenDetails.getAutorizacion());
                    preOrden.setObservaciones(preOrdenDetails.getObservaciones());
                    preOrden.setUsuarioModificacion(preOrdenDetails.getUsuarioModificacion());
                    
                    PreOrden updated = preOrdenRepository.save(preOrden);
                    
                    auditoriaService.registrarAccion("PREORDEN", updated.getNumero(), "ACTUALIZAR", 
                                                      estadoAnterior, updated.getEstado(), 
                                                      "PreOrden actualizada", 
                                                      preOrdenDetails.getUsuarioModificacion());
                    return updated;
                })
                .orElse(null);
    }

    public void deleteById(Long id) {
        preOrdenRepository.findById(id).ifPresent(preOrden -> {
            auditoriaService.registrarAccion("PREORDEN", preOrden.getNumero(), "ELIMINAR", 
                                              preOrden.getEstado(), null, 
                                              "PreOrden eliminada", 
                                              preOrden.getUsuarioModificacion());
            preOrdenRepository.deleteById(id);
        });
    }

    public String generateNextNumero() {
        long count = preOrdenRepository.count();
        return String.format("PRE-%06d", count + 1);
    }
}
