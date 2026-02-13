package com.formamosacero.services;

import com.formamosacero.models.PreOrden;
import com.formamosacero.repositories.PreOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PreOrdenService {

    @Autowired
    private PreOrdenRepository preOrdenRepository;

    public List<PreOrden> obtenerTodos() {
        return preOrdenRepository.findAll();
    }

    public Optional<PreOrden> obtenerPorId(Long id) {
        return preOrdenRepository.findById(id);
    }

    public PreOrden guardar(PreOrden preOrden) {
        return preOrdenRepository.save(preOrden);
    }

    public PreOrden actualizar(Long id, PreOrden preOrdenDetails) {
        Optional<PreOrden> preOrden = preOrdenRepository.findById(id);
        if (preOrden.isPresent()) {
            PreOrden p = preOrden.get();
            p.setNumero(preOrdenDetails.getNumero());
            p.setFecha(preOrdenDetails.getFecha());
            p.setCliente(preOrdenDetails.getCliente());
            p.setProveedor(preOrdenDetails.getProveedor());
            p.setSolicitante(preOrdenDetails.getSolicitante());
            p.setArea(preOrdenDetails.getArea());
            p.setConcepto(preOrdenDetails.getConcepto());
            p.setMonto(preOrdenDetails.getMonto());
            p.setMoneda(preOrdenDetails.getMoneda());
            p.setEstado(preOrdenDetails.getEstado());
            p.setVbGerencia(preOrdenDetails.getVbGerencia());
            p.setAutorizacion(preOrdenDetails.getAutorizacion());
            p.setObservaciones(preOrdenDetails.getObservaciones());
            return preOrdenRepository.save(p);
        }
        return null;
    }

    public void eliminar(Long id) {
        preOrdenRepository.deleteById(id);
    }

    public PreOrden buscarPorNumero(String numero) {
        return preOrdenRepository.findByNumero(numero);
    }

    public List<PreOrden> buscarPorEstado(String estado) {
        return preOrdenRepository.findByEstado(estado);
    }

    public List<PreOrden> buscarPorCliente(Long clienteId) {
        return preOrdenRepository.findByClienteId(clienteId);
    }

    public List<PreOrden> buscarPorProveedor(Long proveedorId) {
        return preOrdenRepository.findByProveedorId(proveedorId);
    }

    public List<PreOrden> buscarPorRangoFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return preOrdenRepository.findByFechaBetween(fechaInicio, fechaFin);
    }
}
