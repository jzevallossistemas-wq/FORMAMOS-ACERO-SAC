package com.formamosacero.services;

import com.formamosacero.models.SolicitudViatico;
import com.formamosacero.repositories.SolicitudViaticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitudViaticoService {

    @Autowired
    private SolicitudViaticoRepository solicitudViaticoRepository;

    public List<SolicitudViatico> obtenerTodos() {
        return solicitudViaticoRepository.findAll();
    }

    public Optional<SolicitudViatico> obtenerPorId(Long id) {
        return solicitudViaticoRepository.findById(id);
    }

    public SolicitudViatico guardar(SolicitudViatico solicitudViatico) {
        return solicitudViaticoRepository.save(solicitudViatico);
    }

    public SolicitudViatico actualizar(Long id, SolicitudViatico solicitudDetails) {
        Optional<SolicitudViatico> solicitud = solicitudViaticoRepository.findById(id);
        if (solicitud.isPresent()) {
            SolicitudViatico s = solicitud.get();
            s.setNumero(solicitudDetails.getNumero());
            s.setFecha(solicitudDetails.getFecha());
            s.setCliente(solicitudDetails.getCliente());
            s.setSolicitante(solicitudDetails.getSolicitante());
            s.setArea(solicitudDetails.getArea());
            s.setDestino(solicitudDetails.getDestino());
            s.setFechaInicio(solicitudDetails.getFechaInicio());
            s.setFechaFin(solicitudDetails.getFechaFin());
            s.setRuta(solicitudDetails.getRuta());
            s.setTipoTransporte(solicitudDetails.getTipoTransporte());
            s.setCombustible(solicitudDetails.getCombustible());
            s.setAlimentacion(solicitudDetails.getAlimentacion());
            s.setHospedaje(solicitudDetails.getHospedaje());
            s.setOtros(solicitudDetails.getOtros());
            s.setTotalSolicitado(solicitudDetails.getTotalSolicitado());
            s.setEstado(solicitudDetails.getEstado());
            s.setObservaciones(solicitudDetails.getObservaciones());
            return solicitudViaticoRepository.save(s);
        }
        return null;
    }

    public void eliminar(Long id) {
        solicitudViaticoRepository.deleteById(id);
    }

    public SolicitudViatico buscarPorNumero(String numero) {
        return solicitudViaticoRepository.findByNumero(numero);
    }

    public List<SolicitudViatico> buscarPorEstado(String estado) {
        return solicitudViaticoRepository.findByEstado(estado);
    }

    public List<SolicitudViatico> buscarPorCliente(Long clienteId) {
        return solicitudViaticoRepository.findByClienteId(clienteId);
    }

    public List<SolicitudViatico> buscarPorDestino(String destino) {
        return solicitudViaticoRepository.findByDestino(destino);
    }

    public List<SolicitudViatico> buscarPorRangoFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return solicitudViaticoRepository.findByFechaBetween(fechaInicio, fechaFin);
    }
}
