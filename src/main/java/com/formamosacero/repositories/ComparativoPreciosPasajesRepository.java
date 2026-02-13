package com.formamosacero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.formamosacero.models.ComparativoPreciosPasajes;

@Repository
public interface ComparativoPreciosPasajesRepository extends JpaRepository<ComparativoPreciosPasajes, Long> {
    ComparativoPreciosPasajes findByNumero(String numero);
}
