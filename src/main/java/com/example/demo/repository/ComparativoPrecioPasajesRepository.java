package com.example.demo.repository;

import com.example.demo.entity.ComparativoPrecioPasajes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComparativoPrecioPasajesRepository extends JpaRepository<ComparativoPrecioPasajes, Long> {
    Optional<ComparativoPrecioPasajes> findByNumero(String numero);
}
