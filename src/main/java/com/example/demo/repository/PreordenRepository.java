package com.example.demo.repository;

import com.example.demo.entity.Preorden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PreordenRepository extends JpaRepository<Preorden, Long> {
    Optional<Preorden> findByNumero(String numero);
}
