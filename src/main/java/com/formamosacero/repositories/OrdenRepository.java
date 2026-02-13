package com.formamosacero.repositories;

import com.formamosacero.models.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {
    Orden findByNumero(String numero);
    List<Orden> findByEstado(String estado);
    List<Orden> findByClienteId(Long clienteId);
    List<Orden> findByProveedorId(Long proveedorId);
    List<Orden> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin);
    List<Orden> findByNumeroContainingIgnoreCase(String numero);
}
