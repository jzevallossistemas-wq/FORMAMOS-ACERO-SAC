package com.formamosacero.services;

import com.formamosacero.models.Proveedor;
import com.formamosacero.repositories.ProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public List<Proveedor> findAll() {
        return proveedorRepository.findAll();
    }

    public Page<Proveedor> findAll(Pageable pageable) {
        return proveedorRepository.findAll(pageable);
    }

    public Optional<Proveedor> findById(Long id) {
        return proveedorRepository.findById(id);
    }

    public Optional<Proveedor> findByRuc(String ruc) {
        return proveedorRepository.findByRuc(ruc);
    }

    public List<Proveedor> findByRazonSocial(String razonSocial) {
        return proveedorRepository.findByRazonSocialContainingIgnoreCase(razonSocial);
    }

    public List<Proveedor> findByEstado(String estado) {
        return proveedorRepository.findByEstado(estado);
    }

    public Proveedor save(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public Proveedor update(Long id, Proveedor proveedorDetails) {
        return proveedorRepository.findById(id)
                .map(proveedor -> {
                    proveedor.setRuc(proveedorDetails.getRuc());
                    proveedor.setRazonSocial(proveedorDetails.getRazonSocial());
                    proveedor.setContacto(proveedorDetails.getContacto());
                    proveedor.setEmail(proveedorDetails.getEmail());
                    proveedor.setTelefono(proveedorDetails.getTelefono());
                    proveedor.setDireccion(proveedorDetails.getDireccion());
                    proveedor.setCiudad(proveedorDetails.getCiudad());
                    proveedor.setPais(proveedorDetails.getPais());
                    proveedor.setTipoProveedor(proveedorDetails.getTipoProveedor());
                    proveedor.setCategoria(proveedorDetails.getCategoria());
                    proveedor.setEstado(proveedorDetails.getEstado());
                    return proveedorRepository.save(proveedor);
                })
                .orElse(null);
    }

    public void deleteById(Long id) {
        proveedorRepository.deleteById(id);
    }

    public boolean existsByRuc(String ruc) {
        return proveedorRepository.findByRuc(ruc).isPresent();
    }
}
