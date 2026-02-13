package com.example.demo.service;

import com.example.demo.entity.Orden;
import com.example.demo.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    public Orden save(Orden orden) {
        return ordenRepository.save(orden);
    }

    public List<Orden> findAll() {
        return ordenRepository.findAll();
    }

    public Orden findById(Long id) {
        Optional<Orden> orden = ordenRepository.findById(id);
        return orden.orElse(null);
    }

    public Orden update(Long id, Orden ordenDetails) {
        Optional<Orden> orden = ordenRepository.findById(id);
        if (orden.isPresent()) {
            Orden existingOrden = orden.get();
            if (ordenDetails.getNumero() != null) {
                existingOrden.setNumero(ordenDetails.getNumero());
            }
            if (ordenDetails.getFecha() != null) {
                existingOrden.setFecha(ordenDetails.getFecha());
            }
            if (ordenDetails.getProveedor() != null) {
                existingOrden.setProveedor(ordenDetails.getProveedor());
            }
            return ordenRepository.save(existingOrden);
        }
        return null;
    }

    public void delete(Long id) {
        ordenRepository.deleteById(id);
    }
}