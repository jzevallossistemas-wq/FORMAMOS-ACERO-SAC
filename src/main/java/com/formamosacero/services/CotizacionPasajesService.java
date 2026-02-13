package com.formamosacero.services;

import com.formamosacero.models.CotizacionPasajes;
import com.formamosacero.repositories.CotizacionPasajesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CotizacionPasajesService {

    @Autowired
    private CotizacionPasajesRepository cotizacionRepository;

    public Page<CotizacionPasajes> obtenerTodos(Pageable pageable) {
        return cotizacionRepository.findAll(pageable);
    }

    public List<CotizacionPasajes> obtenerTodos() {
        return cotizacionRepository.findAll();
    }

    public Optional<CotizacionPasajes> obtenerPorId(Long id) {
        return cotizacionRepository.findById(id);
    }

    public CotizacionPasajes guardar(CotizacionPasajes cotizacion) {
        return cotizacionRepository.save(cotizacion);
    }

    public CotizacionPasajes actualizar(Long id, CotizacionPasajes cotizacionDetails) {
        Optional<CotizacionPasajes> cotizacion = cotizacionRepository.findById(id);
        if (cotizacion.isPresent()) {
            CotizacionPasajes c = cotizacion.get();
            c.setNumero(cotizacionDetails.getNumero());
            c.setDestino(cotizacionDetails.getDestino());
            c.setRuta(cotizacionDetails.getRuta());
            c.setFechaViaje(cotizacionDetails.getFechaViaje());
            c.setAerolinea1(cotizacionDetails.getAerolinea1());
            c.setPrecio1(cotizacionDetails.getPrecio1());
            c.setAerolinea2(cotizacionDetails.getAerolinea2());
            c.setPrecio2(cotizacionDetails.getPrecio2());
            c.setAerolinea3(cotizacionDetails.getAerolinea3());
            c.setPrecio3(cotizacionDetails.getPrecio3());
            c.setMejorOpcion(cotizacionDetails.getMejorOpcion());
            return cotizacionRepository.save(c);
        }
        return null;
    }

    public void eliminar(Long id) {
        cotizacionRepository.deleteById(id);
    }
}
