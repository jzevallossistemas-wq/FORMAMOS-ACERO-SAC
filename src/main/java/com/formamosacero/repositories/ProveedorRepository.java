package com.formamosacero.repositories;

import com.formamosacero.models.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long>, JpaSpecificationExecutor<Proveedor> {
    
    Optional<Proveedor> findByRuc(String ruc);
    
    List<Proveedor> findByRazonSocialContainingIgnoreCase(String razonSocial);
    
    Optional<Proveedor> findByEmail(String email);
    
    List<Proveedor> findByEstado(String estado);
    
    List<Proveedor> findByTipoProveedor(String tipoProveedor);
    
    List<Proveedor> findByCategoria(String categoria);
}