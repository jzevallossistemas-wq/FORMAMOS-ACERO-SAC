package com.formamosacero.repositories;

import com.formamosacero.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>, JpaSpecificationExecutor<Cliente> {
    
    Optional<Cliente> findByEmail(String email);
    
    Optional<Cliente> findByDni(String dni);
    
    Optional<Cliente> findByRuc(String ruc);
    
    List<Cliente> findByRazonSocialContainingIgnoreCase(String razonSocial);
    
    List<Cliente> findByNombresContainingIgnoreCase(String nombres);
    
    List<Cliente> findByEstado(String estado);
    
    List<Cliente> findByArea(String area);
    
    List<Cliente> findByDepartamento(String departamento);
    
    @Query("SELECT c FROM Cliente c WHERE c.dni = :dniOrRuc OR c.ruc = :dniOrRuc")
    Optional<Cliente> findByDniOrRuc(@Param("dniOrRuc") String dniOrRuc);
}