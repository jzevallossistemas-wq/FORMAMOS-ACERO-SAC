package com.formamosacero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.formamosacero.models.Cliente;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByEmail(String email);
    Cliente findByDni(String dni);
    Cliente findByRuc(String ruc);
    List<Cliente> findByRazonSocialContainingIgnoreCase(String razonSocial);
    List<Cliente> findByNombresContainingIgnoreCase(String nombres);
    List<Cliente> findByEstado(String estado);
}