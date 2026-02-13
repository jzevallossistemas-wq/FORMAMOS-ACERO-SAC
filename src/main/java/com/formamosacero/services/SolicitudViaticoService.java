package com.formamosacero.services;

import com.formamosacero.models.SolicitudGastoViaje;
import com.formamosacero.repositories.SolicitudGastoViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudViaticoService {

    @Autowired
    private SolicitudGastoViajeRepository solicitudRepository;

    public Page<SolicitudGastoViaje> obtenerTodos(Pageable pageable) {
        return solicitudRepository.findAll(pageable);
    }

    public List<SolicitudGastoViaje> obtenerTodos() {
        return solicitudRepository.findAll();
    }

    public Optional<SolicitudGastoViaje> obtenerPorId(Long id) {
        return solicitudRepository.findById(id);
    }

    public SolicitudGastoViaje guardar(SolicitudGastoViaje solicitud) {
        return solicitudRepository.save(solicitud);
    }

    public SolicitudGastoViaje actualizar(Long id, SolicitudGastoViaje solicitudDetails) {
        Optional<SolicitudGastoViaje> solicitud = solicitudRepository.findById(id);
        if (solicitud.isPresent()) {
            SolicitudGastoViaje s = solicitud.get();
            s.setMonto(solicitudDetails.getMonto());
            s.setDescripcion(solicitudDetails.getDescripcion());
            s.setFechaSolicitud(solicitudDetails.getFechaSolicitud());
            s.setEstado(solicitudDetails.getEstado());
            return solicitudRepository.save(s);
        }
        return null;
    }

    public void eliminar(Long id) {
        solicitudRepository.deleteById(id);
    }
}
