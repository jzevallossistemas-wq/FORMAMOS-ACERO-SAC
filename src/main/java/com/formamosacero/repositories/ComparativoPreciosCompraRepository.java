package com.formamosacero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.formamosacero.models.ComparativoPreciosCompra;

@Repository
public interface ComparativoPreciosCompraRepository extends JpaRepository<ComparativoPreciosCompra, Long> {
    ComparativoPreciosCompra findByNumero(String numero);
}
