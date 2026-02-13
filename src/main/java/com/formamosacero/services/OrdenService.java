package com.formamosacero.services;

import com.formamosacero.models.Orden;
import com.formamosacero.repositories.OrdenRepository;
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
public class OrdenService {

    private final OrdenRepository ordenRepository;
    private final AuditoriaService auditoriaService;

    public List<Orden> findAll() {
        return ordenRepository.findAll();
    }

    public Page<Orden> findAll(Pageable pageable) {
        return ordenRepository.findAll(pageable);
    }

    public Optional<Orden> findById(Long id) {
        return ordenRepository.findById(id);
    }

    public Optional<Orden> findByNumero(String numero) {
        return ordenRepository.findByNumero(numero);
    }

    public List<Orden> findByEstado(String estado) {
        return ordenRepository.findByEstado(estado);
    }

    public List<Orden> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin) {
        return ordenRepository.findByFechaBetween(fechaInicio, fechaFin);
    }

    public Orden save(Orden orden) {
        Orden saved = ordenRepository.save(orden);
        auditoriaService.registrarAccion("ORDEN", saved.getNumero(), "CREAR", 
                                          null, saved.getEstado(), "Orden creada", 
                                          orden.getUsuarioCreacion());
        return saved;
    }

    public Orden update(Long id, Orden ordenDetails) {
        return ordenRepository.findById(id)
                .map(orden -> {
                    String estadoAnterior = orden.getEstado();
                    
                    orden.setFecha(ordenDetails.getFecha());
                    orden.setCliente(ordenDetails.getCliente());
                    orden.setProveedor(ordenDetails.getProveedor());
                    orden.setSolicitante(ordenDetails.getSolicitante());
                    orden.setArea(ordenDetails.getArea());
                    orden.setConcepto(ordenDetails.getConcepto());
                    orden.setSubtotal(ordenDetails.getSubtotal());
                    orden.setDescuento(ordenDetails.getDescuento());
                    orden.setImpuesto(ordenDetails.getImpuesto());
                    orden.setTotal(ordenDetails.getTotal());
                    orden.setMoneda(ordenDetails.getMoneda());
                    orden.setFormaPago(ordenDetails.getFormaPago());
                    orden.setLugarEntrega(ordenDetails.getLugarEntrega());
                    orden.setFechaEntrega(ordenDetails.getFechaEntrega());
                    orden.setEstado(ordenDetails.getEstado());
                    orden.setAutorizacion(ordenDetails.getAutorizacion());
                    orden.setObservaciones(ordenDetails.getObservaciones());
                    orden.setUsuarioModificacion(ordenDetails.getUsuarioModificacion());
                    
                    Orden updated = ordenRepository.save(orden);
                    
                    auditoriaService.registrarAccion("ORDEN", updated.getNumero(), "ACTUALIZAR", 
                                                      estadoAnterior, updated.getEstado(), 
                                                      "Orden actualizada", 
                                                      ordenDetails.getUsuarioModificacion());
                    return updated;
                })
                .orElse(null);
    }

    public void deleteById(Long id) {
        ordenRepository.findById(id).ifPresent(orden -> {
            auditoriaService.registrarAccion("ORDEN", orden.getNumero(), "ELIMINAR", 
                                              orden.getEstado(), null, 
                                              "Orden eliminada", 
                                              orden.getUsuarioModificacion());
            ordenRepository.deleteById(id);
        });
    }

    public String generateNextNumero() {
        long count = ordenRepository.count();
        return String.format("ORD-%06d", count + 1);
    }
}
