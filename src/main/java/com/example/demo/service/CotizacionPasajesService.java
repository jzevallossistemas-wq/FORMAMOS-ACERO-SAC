package com.example.demo.service;

import com.example.demo.entity.CotizacionPasajes;
import com.example.demo.repository.CotizacionPasajesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CotizacionPasajesService {

    @Autowired
    private CotizacionPasajesRepository cotizacionPasajesRepository;

    public CotizacionPasajes createCotizacion(CotizacionPasajes cotizacion) {
        return cotizacionPasajesRepository.save(cotizacion);
    }

    public List<CotizacionPasajes> getAllCotizaciones() {
        return cotizacionPasajesRepository.findAll();
    }

    public CotizacionPasajes getCotizacionById(Long id) {
        Optional<CotizacionPasajes> cotizacion = cotizacionPasajesRepository.findById(id);
        return cotizacion.orElse(null);
    }

    public CotizacionPasajes updateCotizacion(Long id, CotizacionPasajes cotizacionDetails) {
        Optional<CotizacionPasajes> cotizacion = cotizacionPasajesRepository.findById(id);
        if (cotizacion.isPresent()) {
            CotizacionPasajes existingCotizacion = cotizacion.get();
            if (cotizacionDetails.getOrigen() != null) {
                existingCotizacion.setOrigen(cotizacionDetails.getOrigen());
            }
            if (cotizacionDetails.getDestino() != null) {
                existingCotizacion.setDestino(cotizacionDetails.getDestino());
            }
            if (cotizacionDetails.getPrecio() != null) {
                existingCotizacion.setPrecio(cotizacionDetails.getPrecio());
            }
            return cotizacionPasajesRepository.save(existingCotizacion);
        }
        return null;
    }

    public void deleteCotizacion(Long id) {
        cotizacionPasajesRepository.deleteById(id);
    }
}