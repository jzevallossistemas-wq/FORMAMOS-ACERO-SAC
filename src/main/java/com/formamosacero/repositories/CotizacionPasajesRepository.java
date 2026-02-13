package com.formamosacero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.formamosacero.models.CotizacionPasajes;

@Repository
public interface CotizacionPasajesRepository extends JpaRepository<CotizacionPasajes, Long> {
    CotizacionPasajes findByNumero(String numero);
}
