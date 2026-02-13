package com.formamosacero.repositories;

import com.formamosacero.models.ComparativoPreciosCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ComparativoPreciosCompraRepository extends JpaRepository<ComparativoPreciosCompra, Long> {
    ComparativoPreciosCompra findByNumero(String numero);
    List<ComparativoPreciosCompra> findByEstado(String estado);
    List<ComparativoPreciosCompra> findByClienteId(Long clienteId);
    List<ComparativoPreciosCompra> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin);
    List<ComparativoPreciosCompra> findByNumeroContainingIgnoreCase(String numero);
}
