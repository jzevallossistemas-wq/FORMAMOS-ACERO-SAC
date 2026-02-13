package com.formamosacero.services;

import com.formamosacero.models.OrdenCompra;
import com.formamosacero.repositories.OrdenCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenService {

    @Autowired
    private OrdenCompraRepository ordenRepository;

    public Page<OrdenCompra> obtenerTodos(Pageable pageable) {
        return ordenRepository.findAll(pageable);
    }

    public List<OrdenCompra> obtenerTodos() {
        return ordenRepository.findAll();
    }

    public Optional<OrdenCompra> obtenerPorId(Long id) {
        return ordenRepository.findById(id);
    }

    public OrdenCompra guardar(OrdenCompra orden) {
        return ordenRepository.save(orden);
    }

    public OrdenCompra actualizar(Long id, OrdenCompra ordenDetails) {
        Optional<OrdenCompra> orden = ordenRepository.findById(id);
        if (orden.isPresent()) {
            OrdenCompra o = orden.get();
            o.setNumero(ordenDetails.getNumero());
            o.setFecha(ordenDetails.getFecha());
            o.setProveedorId(ordenDetails.getProveedorId());
            o.setMontoTotal(ordenDetails.getMontoTotal());
            o.setEstado(ordenDetails.getEstado());
            return ordenRepository.save(o);
        }
        return null;
    }

    public void eliminar(Long id) {
        ordenRepository.deleteById(id);
    }
}
