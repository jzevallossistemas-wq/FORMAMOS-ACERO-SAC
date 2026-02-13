package com.example.demo.service;

import com.example.demo.entity.SolicitudEfectivo;
import com.example.demo.repository.SolicitudEfectivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudEfectivoService {

    @Autowired
    private SolicitudEfectivoRepository solicitudEfectivoRepository;

    public SolicitudEfectivo createSolicitud(SolicitudEfectivo solicitudEfectivo) {
        return solicitudEfectivoRepository.save(solicitudEfectivo);
    }

    public List<SolicitudEfectivo> getAllSolicitudes() {
        return solicitudEfectivoRepository.findAll();
    }

    public SolicitudEfectivo getSolicitudById(Long id) {
        Optional<SolicitudEfectivo> solicitud = solicitudEfectivoRepository.findById(id);
        return solicitud.orElse(null);
    }

    public SolicitudEfectivo updateSolicitud(Long id, SolicitudEfectivo solicitudEfectivoDetails) {
        Optional<SolicitudEfectivo> solicitud = solicitudEfectivoRepository.findById(id);
        if (solicitud.isPresent()) {
            SolicitudEfectivo existingSolicitud = solicitud.get();
            if (solicitudEfectivoDetails.getMonto() != null) {
                existingSolicitud.setMonto(solicitudEfectivoDetails.getMonto());
            }
            if (solicitudEfectivoDetails.getFecha() != null) {
                existingSolicitud.setFecha(solicitudEfectivoDetails.getFecha());
            }
            return solicitudEfectivoRepository.save(existingSolicitud);
        }
        return null;
    }

    public boolean deleteSolicitud(Long id) {
        if (solicitudEfectivoRepository.existsById(id)) {
            solicitudEfectivoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}