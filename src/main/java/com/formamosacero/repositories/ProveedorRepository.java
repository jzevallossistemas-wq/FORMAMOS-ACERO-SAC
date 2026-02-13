package com.formamosacero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.formamosacero.models.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    Proveedor findByNombre(String nombre);
    Proveedor findByEmail(String email);
}