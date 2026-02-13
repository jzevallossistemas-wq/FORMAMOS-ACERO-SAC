package com.formamosacero.services;

import com.formamosacero.models.ComparativoPreciosCompra;
import com.formamosacero.repositories.ComparativoPreciosCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ComparativoPreciosCompraService {

    @Autowired
    private ComparativoPreciosCompraRepository comparativoPreciosCompraRepository;

    public List<ComparativoPreciosCompra> obtenerTodos() {
        return comparativoPreciosCompraRepository.findAll();
    }

    public Optional<ComparativoPreciosCompra> obtenerPorId(Long id) {
        return comparativoPreciosCompraRepository.findById(id);
    }

    public ComparativoPreciosCompra guardar(ComparativoPreciosCompra comparativo) {
        return comparativoPreciosCompraRepository.save(comparativo);
    }

    public ComparativoPreciosCompra actualizar(Long id, ComparativoPreciosCompra comparativoDetails) {
        Optional<ComparativoPreciosCompra> comparativo = comparativoPreciosCompraRepository.findById(id);
        if (comparativo.isPresent()) {
            ComparativoPreciosCompra c = comparativo.get();
            c.setNumero(comparativoDetails.getNumero());
            c.setFecha(comparativoDetails.getFecha());
            c.setCliente(comparativoDetails.getCliente());
            c.setSolicitante(comparativoDetails.getSolicitante());
            c.setDescripcionProducto(comparativoDetails.getDescripcionProducto());
            c.setProveedor1(comparativoDetails.getProveedor1());
            c.setProveedor1Cantidad(comparativoDetails.getProveedor1Cantidad());
            c.setProveedor1PrecioUnitario(comparativoDetails.getProveedor1PrecioUnitario());
            c.setProveedor1IGV(comparativoDetails.getProveedor1IGV());
            c.setProveedor1Total(comparativoDetails.getProveedor1Total());
            c.setProveedor2(comparativoDetails.getProveedor2());
            c.setProveedor2Cantidad(comparativoDetails.getProveedor2Cantidad());
            c.setProveedor2PrecioUnitario(comparativoDetails.getProveedor2PrecioUnitario());
            c.setProveedor2IGV(comparativoDetails.getProveedor2IGV());
            c.setProveedor2Total(comparativoDetails.getProveedor2Total());
            c.setProveedor3(comparativoDetails.getProveedor3());
            c.setProveedor3Cantidad(comparativoDetails.getProveedor3Cantidad());
            c.setProveedor3PrecioUnitario(comparativoDetails.getProveedor3PrecioUnitario());
            c.setProveedor3IGV(comparativoDetails.getProveedor3IGV());
            c.setProveedor3Total(comparativoDetails.getProveedor3Total());
            c.setMoneda(comparativoDetails.getMoneda());
            c.setFormaPago(comparativoDetails.getFormaPago());
            c.setLugarEntrega(comparativoDetails.getLugarEntrega());
            c.setEstado(comparativoDetails.getEstado());
            c.setObservaciones(comparativoDetails.getObservaciones());
            return comparativoPreciosCompraRepository.save(c);
        }
        return null;
    }

    public void eliminar(Long id) {
        comparativoPreciosCompraRepository.deleteById(id);
    }

    public ComparativoPreciosCompra buscarPorNumero(String numero) {
        return comparativoPreciosCompraRepository.findByNumero(numero);
    }

    public List<ComparativoPreciosCompra> buscarPorEstado(String estado) {
        return comparativoPreciosCompraRepository.findByEstado(estado);
    }

    public List<ComparativoPreciosCompra> buscarPorCliente(Long clienteId) {
        return comparativoPreciosCompraRepository.findByClienteId(clienteId);
    }

    public List<ComparativoPreciosCompra> buscarPorRangoFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return comparativoPreciosCompraRepository.findByFechaBetween(fechaInicio, fechaFin);
    }
}
