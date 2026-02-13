package com.example.demo.repository;

import com.example.demo.entity.ComparativoPrecioCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComparativoPrecioCompraRepository extends JpaRepository<ComparativoPrecioCompra, Long> {
    Optional<ComparativoPrecioCompra> findByNumero(String numero);
}
