package com.example.demo.service;

import com.example.demo.entity.SolicitudViatico;
import com.example.demo.repository.SolicitudViaticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudViaticoService {

    @Autowired
    private SolicitudViaticoRepository solicitudViaticoRepository;

    public SolicitudViatico createSolicitudViatico(SolicitudViatico solicitudViatico) {
        return solicitudViaticoRepository.save(solicitudViatico);
    }

    public List<SolicitudViatico> getAllSolicitudViaticos() {
        return solicitudViaticoRepository.findAll();
    }

    public SolicitudViatico getSolicitudViaticoById(Long id) {
        Optional<SolicitudViatico> solicitudViatico = solicitudViaticoRepository.findById(id);
        return solicitudViatico.orElse(null);
    }

    public SolicitudViatico updateSolicitudViatico(Long id, SolicitudViatico solicitudViaticoDetails) {
        Optional<SolicitudViatico> solicitudViatico = solicitudViaticoRepository.findById(id);
        if (solicitudViatico.isPresent()) {
            SolicitudViatico existingSolicitud = solicitudViatico.get();
            if (solicitudViaticoDetails.getMonto() != null) {
                existingSolicitud.setMonto(solicitudViaticoDetails.getMonto());
            }
            if (solicitudViaticoDetails.getFecha() != null) {
                existingSolicitud.setFecha(solicitudViaticoDetails.getFecha());
            }
            return solicitudViaticoRepository.save(existingSolicitud);
        }
        return null;
    }

    public void deleteSolicitudViatico(Long id) {
        solicitudViaticoRepository.deleteById(id);
    }
}