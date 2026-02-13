package com.example.demo.service;

import com.example.demo.entity.ComparativoPrecioCompra;
import com.example.demo.repository.ComparativoPrecioCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComparativoPrecioCompraService {

    @Autowired
    private ComparativoPrecioCompraRepository comparativoPrecioCompraRepository;

    public ComparativoPrecioCompra create(ComparativoPrecioCompra comparativoPrecioCompra) {
        return comparativoPrecioCompraRepository.save(comparativoPrecioCompra);
    }

    public List<ComparativoPrecioCompra> getAll() {
        return comparativoPrecioCompraRepository.findAll();
    }

    public ComparativoPrecioCompra getById(Long id) {
        Optional<ComparativoPrecioCompra> comparativoPrecioCompra = comparativoPrecioCompraRepository.findById(id);
        return comparativoPrecioCompra.orElse(null);
    }

    public ComparativoPrecioCompra update(Long id, ComparativoPrecioCompra comparativoPrecioCompraDetails) {
        Optional<ComparativoPrecioCompra> comparativoPrecioCompra = comparativoPrecioCompraRepository.findById(id);
        if (comparativoPrecioCompra.isPresent()) {
            ComparativoPrecioCompra existing = comparativoPrecioCompra.get();
            if (comparativoPrecioCompraDetails.getNombre() != null) {
                existing.setNombre(comparativoPrecioCompraDetails.getNombre());
            }
            if (comparativoPrecioCompraDetails.getPrecio() != null) {
                existing.setPrecio(comparativoPrecioCompraDetails.getPrecio());
            }
            if (comparativoPrecioCompraDetails.getProveedor() != null) {
                existing.setProveedor(comparativoPrecioCompraDetails.getProveedor());
            }
            return comparativoPrecioCompraRepository.save(existing);
        }
        return null;
    }

    public void delete(Long id) {
        comparativoPrecioCompraRepository.deleteById(id);
    }
}