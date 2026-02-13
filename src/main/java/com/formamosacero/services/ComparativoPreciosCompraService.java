package com.formamosacero.services;

import com.formamosacero.models.ComparativoPreciosCompra;
import com.formamosacero.repositories.ComparativoPreciosCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComparativoPreciosCompraService {

    @Autowired
    private ComparativoPreciosCompraRepository comparativoRepository;

    public Page<ComparativoPreciosCompra> obtenerTodos(Pageable pageable) {
        return comparativoRepository.findAll(pageable);
    }

    public List<ComparativoPreciosCompra> obtenerTodos() {
        return comparativoRepository.findAll();
    }

    public Optional<ComparativoPreciosCompra> obtenerPorId(Long id) {
        return comparativoRepository.findById(id);
    }

    public ComparativoPreciosCompra guardar(ComparativoPreciosCompra comparativo) {
        return comparativoRepository.save(comparativo);
    }

    public ComparativoPreciosCompra actualizar(Long id, ComparativoPreciosCompra comparativoDetails) {
        Optional<ComparativoPreciosCompra> comparativo = comparativoRepository.findById(id);
        if (comparativo.isPresent()) {
            ComparativoPreciosCompra c = comparativo.get();
            c.setNumero(comparativoDetails.getNumero());
            c.setProducto(comparativoDetails.getProducto());
            c.setFechaComparacion(comparativoDetails.getFechaComparacion());
            c.setProveedor1(comparativoDetails.getProveedor1());
            c.setPrecio1(comparativoDetails.getPrecio1());
            c.setProveedor2(comparativoDetails.getProveedor2());
            c.setPrecio2(comparativoDetails.getPrecio2());
            c.setProveedor3(comparativoDetails.getProveedor3());
            c.setPrecio3(comparativoDetails.getPrecio3());
            c.setMejorOpcion(comparativoDetails.getMejorOpcion());
            c.setObservaciones(comparativoDetails.getObservaciones());
            return comparativoRepository.save(c);
        }
        return null;
    }

    public void eliminar(Long id) {
        comparativoRepository.deleteById(id);
    }
}
