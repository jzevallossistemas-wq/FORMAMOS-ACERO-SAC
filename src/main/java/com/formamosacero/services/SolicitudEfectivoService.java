package com.formamosacero.services;

import com.formamosacero.models.SolicitudEfectivo;
import com.formamosacero.repositories.SolicitudEfectivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudEfectivoService {

    @Autowired
    private SolicitudEfectivoRepository solicitudEfectivoRepository;

    public Page<SolicitudEfectivo> obtenerTodos(Pageable pageable) {
        return solicitudEfectivoRepository.findAll(pageable);
    }

    public List<SolicitudEfectivo> obtenerTodos() {
        return solicitudEfectivoRepository.findAll();
    }

    public Optional<SolicitudEfectivo> obtenerPorId(Long id) {
        return solicitudEfectivoRepository.findById(id);
    }

    public SolicitudEfectivo guardar(SolicitudEfectivo solicitud) {
        return solicitudEfectivoRepository.save(solicitud);
    }

    public SolicitudEfectivo actualizar(Long id, SolicitudEfectivo solicitudDetails) {
        Optional<SolicitudEfectivo> solicitud = solicitudEfectivoRepository.findById(id);
        if (solicitud.isPresent()) {
            SolicitudEfectivo s = solicitud.get();
            s.setNumero(solicitudDetails.getNumero());
            s.setClienteId(solicitudDetails.getClienteId());
            s.setMonto(solicitudDetails.getMonto());
            s.setDescripcion(solicitudDetails.getDescripcion());
            s.setFechaSolicitud(solicitudDetails.getFechaSolicitud());
            s.setEstado(solicitudDetails.getEstado());
            return solicitudEfectivoRepository.save(s);
        }
        return null;
    }

    public void eliminar(Long id) {
        solicitudEfectivoRepository.deleteById(id);
    }
}
