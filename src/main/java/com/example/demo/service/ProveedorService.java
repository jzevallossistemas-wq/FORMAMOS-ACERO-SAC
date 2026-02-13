package com.example.demo.service;

import com.example.demo.model.Proveedor;
import com.example.demo.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

    public Proveedor save(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public List<Proveedor> findAll() {
        return proveedorRepository.findAll();
    }

    public Proveedor findById(Long id) {
        Optional<Proveedor> proveedor = proveedorRepository.findById(id);
        return proveedor.orElse(null);
    }

    public Proveedor update(Long id, Proveedor proveedorDetails) {
        Optional<Proveedor> proveedor = proveedorRepository.findById(id);
        if (proveedor.isPresent()) {
            Proveedor existingProveedor = proveedor.get();
            if (proveedorDetails.getNombre() != null) {
                existingProveedor.setNombre(proveedorDetails.getNombre());
            }
            if (proveedorDetails.getEmail() != null) {
                existingProveedor.setEmail(proveedorDetails.getEmail());
            }
            if (proveedorDetails.getTelefono() != null) {
                existingProveedor.setTelefono(proveedorDetails.getTelefono());
            }
            return proveedorRepository.save(existingProveedor);
        }
        return null;
    }

    public void delete(Long id) {
        proveedorRepository.deleteById(id);
    }
}