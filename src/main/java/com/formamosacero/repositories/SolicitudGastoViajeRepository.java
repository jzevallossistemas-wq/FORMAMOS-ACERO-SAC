package com.formamosacero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.formamosacero.models.SolicitudGastoViaje;
import java.util.List;

@Repository
public interface SolicitudGastoViajeRepository extends JpaRepository<SolicitudGastoViaje, Long> {
    List<SolicitudGastoViaje> findByEstado(String estado);
}