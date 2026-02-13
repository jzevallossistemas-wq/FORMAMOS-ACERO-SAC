package com.formamosacero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.formamosacero.models.Proveedor;

import java.util.List;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    Proveedor findByRuc(String ruc);
    Proveedor findByEmail(String email);
    Proveedor findByRazonSocial(String razonSocial);
    List<Proveedor> findByRazonSocialContainingIgnoreCase(String razonSocial);
    List<Proveedor> findByEstado(String estado);
}