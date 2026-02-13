package com.formamosacero.services;

import com.formamosacero.models.SolicitudEfectivo;
import com.formamosacero.repositories.SolicitudEfectivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitudEfectivoService {

    @Autowired
    private SolicitudEfectivoRepository solicitudEfectivoRepository;

    public List<SolicitudEfectivo> obtenerTodos() {
        return solicitudEfectivoRepository.findAll();
    }

    public Optional<SolicitudEfectivo> obtenerPorId(Long id) {
        return solicitudEfectivoRepository.findById(id);
    }

    public SolicitudEfectivo guardar(SolicitudEfectivo solicitudEfectivo) {
        return solicitudEfectivoRepository.save(solicitudEfectivo);
    }

    public SolicitudEfectivo actualizar(Long id, SolicitudEfectivo solicitudDetails) {
        Optional<SolicitudEfectivo> solicitud = solicitudEfectivoRepository.findById(id);
        if (solicitud.isPresent()) {
            SolicitudEfectivo s = solicitud.get();
            s.setNumero(solicitudDetails.getNumero());
            s.setFecha(solicitudDetails.getFecha());
            s.setCliente(solicitudDetails.getCliente());
            s.setSolicitante(solicitudDetails.getSolicitante());
            s.setArea(solicitudDetails.getArea());
            s.setConcepto(solicitudDetails.getConcepto());
            s.setMotivo(solicitudDetails.getMotivo());
            s.setMonto(solicitudDetails.getMonto());
            s.setEstado(solicitudDetails.getEstado());
            s.setAprobacion(solicitudDetails.getAprobacion());
            s.setDesembolso(solicitudDetails.getDesembolso());
            s.setObservaciones(solicitudDetails.getObservaciones());
            return solicitudEfectivoRepository.save(s);
        }
        return null;
    }

    public void eliminar(Long id) {
        solicitudEfectivoRepository.deleteById(id);
    }

    public SolicitudEfectivo buscarPorNumero(String numero) {
        return solicitudEfectivoRepository.findByNumero(numero);
    }

    public List<SolicitudEfectivo> buscarPorEstado(String estado) {
        return solicitudEfectivoRepository.findByEstado(estado);
    }

    public List<SolicitudEfectivo> buscarPorCliente(Long clienteId) {
        return solicitudEfectivoRepository.findByClienteId(clienteId);
    }

    public List<SolicitudEfectivo> buscarPorRangoFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return solicitudEfectivoRepository.findByFechaBetween(fechaInicio, fechaFin);
    }
}
