package com.formamosacero.repositories;

import com.formamosacero.models.PreOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PreOrdenRepository extends JpaRepository<PreOrden, Long> {
    PreOrden findByNumero(String numero);
    List<PreOrden> findByEstado(String estado);
    List<PreOrden> findByClienteId(Long clienteId);
    List<PreOrden> findByProveedorId(Long proveedorId);
    List<PreOrden> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin);
    List<PreOrden> findByNumeroContainingIgnoreCase(String numero);
}
