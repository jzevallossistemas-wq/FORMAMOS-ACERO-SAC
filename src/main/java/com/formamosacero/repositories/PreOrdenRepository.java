package com.formamosacero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.formamosacero.models.PreOrden;

@Repository
public interface PreOrdenRepository extends JpaRepository<PreOrden, Long> {
    PreOrden findByNumero(String numero);
}
