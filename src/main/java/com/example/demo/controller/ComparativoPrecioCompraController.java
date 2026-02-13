package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.ComparativoPrecioCompra;
import com.example.demo.repository.ComparativoPrecioCompraRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comparativo-precio-compra")
public class ComparativoPrecioCompraController {

    @Autowired
    private ComparativoPrecioCompraRepository repository;

    // Create a new ComparativoPrecioCompra
    @PostMapping
    public ComparativoPrecioCompra create(@RequestBody ComparativoPrecioCompra comparativoPrecioCompra) {
        return repository.save(comparativoPrecioCompra);
    }

    // Get all ComparativoPrecioCompra
    @GetMapping
    public List<ComparativoPrecioCompra> getAll() {
        return repository.findAll();
    }

    // Get a ComparativoPrecioCompra by id
    @GetMapping("/{id}")
    public ResponseEntity<ComparativoPrecioCompra> getById(@PathVariable Long id) {
        Optional<ComparativoPrecioCompra> comparativoPrecioCompra = repository.findById(id);
        return comparativoPrecioCompra.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a ComparativoPrecioCompra
    @PutMapping("/{id}")
    public ResponseEntity<ComparativoPrecioCompra> update(@PathVariable Long id, @RequestBody ComparativoPrecioCompra comparativoPrecioCompra) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        comparativoPrecioCompra.setId(id);
        return ResponseEntity.ok(repository.save(comparativoPrecioCompra));
    }

    // Delete a ComparativoPrecioCompra
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}