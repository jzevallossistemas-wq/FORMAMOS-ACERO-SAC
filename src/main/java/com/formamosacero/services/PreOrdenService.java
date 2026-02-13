package com.formamosacero.services;

import com.formamosacero.models.PreOrden;
import com.formamosacero.repositories.PreOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreOrdenService {

    @Autowired
    private PreOrdenRepository preOrdenRepository;

    public Page<PreOrden> obtenerTodos(Pageable pageable) {
        return preOrdenRepository.findAll(pageable);
    }

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
            p.setClienteId(preOrdenDetails.getClienteId());
            p.setProveedorId(preOrdenDetails.getProveedorId());
            p.setMontoTotal(preOrdenDetails.getMontoTotal());
            p.setEstado(preOrdenDetails.getEstado());
            p.setDescripcion(preOrdenDetails.getDescripcion());
            return preOrdenRepository.save(p);
        }
        return null;
    }

    public void eliminar(Long id) {
        preOrdenRepository.deleteById(id);
    }
}
