package com.formamosacero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.formamosacero.models.SolicitudEfectivo;

@Repository
public interface SolicitudEfectivoRepository extends JpaRepository<SolicitudEfectivo, Long> {
    SolicitudEfectivo findByNumero(String numero);
}
