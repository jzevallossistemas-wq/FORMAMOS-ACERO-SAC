package com.formamosacero.services;

import com.formamosacero.models.Proveedor;
import com.formamosacero.repositories.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> obtenerTodos() {
        return proveedorRepository.findAll();
    }

    public Optional<Proveedor> obtenerPorId(Long id) {
        return proveedorRepository.findById(id);
    }

    public Proveedor guardar(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public Proveedor actualizar(Long id, Proveedor proveedorDetails) {
        Optional<Proveedor> proveedor = proveedorRepository.findById(id);
        if (proveedor.isPresent()) {
            Proveedor p = proveedor.get();
            p.setNombre(proveedorDetails.getNombre());
            p.setDireccion(proveedorDetails.getDireccion());
            p.setTelefono(proveedorDetails.getTelefono());
            p.setEmail(proveedorDetails.getEmail());
            return proveedorRepository.save(p);
        }
        return null;
    }

    public void eliminar(Long id) {
        proveedorRepository.deleteById(id);
    }

    public Proveedor buscarPorEmail(String email) {
        return proveedorRepository.findByEmail(email);
    }

    public Proveedor buscarPorNombre(String nombre) {
        return proveedorRepository.findByNombre(nombre);
    }
}