package com.formamosacero.services;

import com.formamosacero.models.CotizacionPasajes;
import com.formamosacero.repositories.CotizacionPasajesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CotizacionPasajesService {

    @Autowired
    private CotizacionPasajesRepository cotizacionPasajesRepository;

    public List<CotizacionPasajes> obtenerTodos() {
        return cotizacionPasajesRepository.findAll();
    }

    public Optional<CotizacionPasajes> obtenerPorId(Long id) {
        return cotizacionPasajesRepository.findById(id);
    }

    public CotizacionPasajes guardar(CotizacionPasajes cotizacionPasajes) {
        return cotizacionPasajesRepository.save(cotizacionPasajes);
    }

    public CotizacionPasajes actualizar(Long id, CotizacionPasajes cotizacionDetails) {
        Optional<CotizacionPasajes> cotizacion = cotizacionPasajesRepository.findById(id);
        if (cotizacion.isPresent()) {
            CotizacionPasajes c = cotizacion.get();
            c.setNumero(cotizacionDetails.getNumero());
            c.setFecha(cotizacionDetails.getFecha());
            c.setCliente(cotizacionDetails.getCliente());
            c.setSolicitante(cotizacionDetails.getSolicitante());
            c.setDestino(cotizacionDetails.getDestino());
            c.setRuta(cotizacionDetails.getRuta());
            c.setItinerario(cotizacionDetails.getItinerario());
            c.setFechaInicio(cotizacionDetails.getFechaInicio());
            c.setFechaFin(cotizacionDetails.getFechaFin());
            c.setAerolinea1(cotizacionDetails.getAerolinea1());
            c.setPrecio1(cotizacionDetails.getPrecio1());
            c.setAerolinea2(cotizacionDetails.getAerolinea2());
            c.setPrecio2(cotizacionDetails.getPrecio2());
            c.setAerolinea3(cotizacionDetails.getAerolinea3());
            c.setPrecio3(cotizacionDetails.getPrecio3());
            c.setMejorOpcion(cotizacionDetails.getMejorOpcion());
            c.setEstado(cotizacionDetails.getEstado());
            c.setObservaciones(cotizacionDetails.getObservaciones());
            return cotizacionPasajesRepository.save(c);
        }
        return null;
    }

    public void eliminar(Long id) {
        cotizacionPasajesRepository.deleteById(id);
    }

    public CotizacionPasajes buscarPorNumero(String numero) {
        return cotizacionPasajesRepository.findByNumero(numero);
    }

    public List<CotizacionPasajes> buscarPorEstado(String estado) {
        return cotizacionPasajesRepository.findByEstado(estado);
    }

    public List<CotizacionPasajes> buscarPorCliente(Long clienteId) {
        return cotizacionPasajesRepository.findByClienteId(clienteId);
    }

    public List<CotizacionPasajes> buscarPorDestino(String destino) {
        return cotizacionPasajesRepository.findByDestino(destino);
    }

    public List<CotizacionPasajes> buscarPorRangoFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return cotizacionPasajesRepository.findByFechaBetween(fechaInicio, fechaFin);
    }
}
