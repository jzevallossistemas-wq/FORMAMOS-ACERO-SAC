package com.formamosacero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.formamosacero.models.OrdenCompra;
import java.util.List;

@Repository
public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Long> {
    List<OrdenCompra> findByEstado(String estado);
    List<OrdenCompra> findByProveedorId(Long proveedorId);
}