package com.formamosacero.services;

import com.formamosacero.models.Orden;
import com.formamosacero.repositories.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    public List<Orden> obtenerTodos() {
        return ordenRepository.findAll();
    }

    public Optional<Orden> obtenerPorId(Long id) {
        return ordenRepository.findById(id);
    }

    public Orden guardar(Orden orden) {
        return ordenRepository.save(orden);
    }

    public Orden actualizar(Long id, Orden ordenDetails) {
        Optional<Orden> orden = ordenRepository.findById(id);
        if (orden.isPresent()) {
            Orden o = orden.get();
            o.setNumero(ordenDetails.getNumero());
            o.setFecha(ordenDetails.getFecha());
            o.setCliente(ordenDetails.getCliente());
            o.setProveedor(ordenDetails.getProveedor());
            o.setSolicitante(ordenDetails.getSolicitante());
            o.setArea(ordenDetails.getArea());
            o.setConcepto(ordenDetails.getConcepto());
            o.setMoneda(ordenDetails.getMoneda());
            o.setSubtotal(ordenDetails.getSubtotal());
            o.setDescuento(ordenDetails.getDescuento());
            o.setImpuesto(ordenDetails.getImpuesto());
            o.setTotal(ordenDetails.getTotal());
            o.setFormaPago(ordenDetails.getFormaPago());
            o.setLugarEntrega(ordenDetails.getLugarEntrega());
            o.setFechaEntrega(ordenDetails.getFechaEntrega());
            o.setEstado(ordenDetails.getEstado());
            o.setVbGerencia(ordenDetails.getVbGerencia());
            o.setAutorizacion(ordenDetails.getAutorizacion());
            o.setObservaciones(ordenDetails.getObservaciones());
            return ordenRepository.save(o);
        }
        return null;
    }

    public void eliminar(Long id) {
        ordenRepository.deleteById(id);
    }

    public Orden buscarPorNumero(String numero) {
        return ordenRepository.findByNumero(numero);
    }

    public List<Orden> buscarPorEstado(String estado) {
        return ordenRepository.findByEstado(estado);
    }

    public List<Orden> buscarPorCliente(Long clienteId) {
        return ordenRepository.findByClienteId(clienteId);
    }

    public List<Orden> buscarPorProveedor(Long proveedorId) {
        return ordenRepository.findByProveedorId(proveedorId);
    }

    public List<Orden> buscarPorRangoFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return ordenRepository.findByFechaBetween(fechaInicio, fechaFin);
    }
}
