package com.formamosacero.services;

import com.formamosacero.models.ComparativoPreciosPasajes;
import com.formamosacero.repositories.ComparativoPreciosPasajesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ComparativoPreciosPasajesService {

    @Autowired
    private ComparativoPreciosPasajesRepository comparativoPreciosPasajesRepository;

    public List<ComparativoPreciosPasajes> obtenerTodos() {
        return comparativoPreciosPasajesRepository.findAll();
    }

    public Optional<ComparativoPreciosPasajes> obtenerPorId(Long id) {
        return comparativoPreciosPasajesRepository.findById(id);
    }

    public ComparativoPreciosPasajes guardar(ComparativoPreciosPasajes comparativo) {
        return comparativoPreciosPasajesRepository.save(comparativo);
    }

    public ComparativoPreciosPasajes actualizar(Long id, ComparativoPreciosPasajes comparativoDetails) {
        Optional<ComparativoPreciosPasajes> comparativo = comparativoPreciosPasajesRepository.findById(id);
        if (comparativo.isPresent()) {
            ComparativoPreciosPasajes c = comparativo.get();
            c.setNumero(comparativoDetails.getNumero());
            c.setFecha(comparativoDetails.getFecha());
            c.setCliente(comparativoDetails.getCliente());
            c.setSolicitante(comparativoDetails.getSolicitante());
            c.setDestino(comparativoDetails.getDestino());
            c.setRuta(comparativoDetails.getRuta());
            c.setItinerario(comparativoDetails.getItinerario());
            c.setFechaInicio(comparativoDetails.getFechaInicio());
            c.setFechaFin(comparativoDetails.getFechaFin());
            c.setAerolinea1Nombre(comparativoDetails.getAerolinea1Nombre());
            c.setAerolinea1Cantidad(comparativoDetails.getAerolinea1Cantidad());
            c.setAerolinea1PrecioUnitario(comparativoDetails.getAerolinea1PrecioUnitario());
            c.setAerolinea1Total(comparativoDetails.getAerolinea1Total());
            c.setAerolinea2Nombre(comparativoDetails.getAerolinea2Nombre());
            c.setAerolinea2Cantidad(comparativoDetails.getAerolinea2Cantidad());
            c.setAerolinea2PrecioUnitario(comparativoDetails.getAerolinea2PrecioUnitario());
            c.setAerolinea2Total(comparativoDetails.getAerolinea2Total());
            c.setAerolinea3Nombre(comparativoDetails.getAerolinea3Nombre());
            c.setAerolinea3Cantidad(comparativoDetails.getAerolinea3Cantidad());
            c.setAerolinea3PrecioUnitario(comparativoDetails.getAerolinea3PrecioUnitario());
            c.setAerolinea3Total(comparativoDetails.getAerolinea3Total());
            c.setMoneda(comparativoDetails.getMoneda());
            c.setEstado(comparativoDetails.getEstado());
            c.setObservaciones(comparativoDetails.getObservaciones());
            return comparativoPreciosPasajesRepository.save(c);
        }
        return null;
    }

    public void eliminar(Long id) {
        comparativoPreciosPasajesRepository.deleteById(id);
    }

    public ComparativoPreciosPasajes buscarPorNumero(String numero) {
        return comparativoPreciosPasajesRepository.findByNumero(numero);
    }

    public List<ComparativoPreciosPasajes> buscarPorEstado(String estado) {
        return comparativoPreciosPasajesRepository.findByEstado(estado);
    }

    public List<ComparativoPreciosPasajes> buscarPorCliente(Long clienteId) {
        return comparativoPreciosPasajesRepository.findByClienteId(clienteId);
    }

    public List<ComparativoPreciosPasajes> buscarPorDestino(String destino) {
        return comparativoPreciosPasajesRepository.findByDestino(destino);
    }

    public List<ComparativoPreciosPasajes> buscarPorRangoFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return comparativoPreciosPasajesRepository.findByFechaBetween(fechaInicio, fechaFin);
    }
}
