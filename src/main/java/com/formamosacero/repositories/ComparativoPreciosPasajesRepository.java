package com.formamosacero.repositories;

import com.formamosacero.models.ComparativoPreciosPasajes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ComparativoPreciosPasajesRepository extends JpaRepository<ComparativoPreciosPasajes, Long> {
    ComparativoPreciosPasajes findByNumero(String numero);
    List<ComparativoPreciosPasajes> findByEstado(String estado);
    List<ComparativoPreciosPasajes> findByClienteId(Long clienteId);
    List<ComparativoPreciosPasajes> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin);
    List<ComparativoPreciosPasajes> findByNumeroContainingIgnoreCase(String numero);
    List<ComparativoPreciosPasajes> findByDestino(String destino);
}
