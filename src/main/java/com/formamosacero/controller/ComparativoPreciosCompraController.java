package com.formamosacero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.formamosacero.model.ComparativoPreciosCompra;
import com.formamosacero.service.ComparativoPreciosCompraService;

import java.util.List;

@RestController
@RequestMapping("/api/comparativo-precios-compra")
public class ComparativoPreciosCompraController {

    @Autowired
    private ComparativoPreciosCompraService comparativoPreciosCompraService;

    @GetMapping
    public List<ComparativoPreciosCompra> getAll() {
        return comparativoPreciosCompraService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComparativoPreciosCompra> getById(@PathVariable Long id) {
        ComparativoPreciosCompra comparativo = comparativoPreciosCompraService.findById(id);
        if (comparativo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(comparativo);
    }

    @PostMapping
    public ComparativoPreciosCompra create(@RequestBody ComparativoPreciosCompra comparativo) {
        return comparativoPreciosCompraService.save(comparativo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComparativoPreciosCompra> update(@PathVariable Long id, @RequestBody ComparativoPreciosCompra comparativo) {
        ComparativoPreciosCompra updatedComparativo = comparativoPreciosCompraService.update(id, comparativo);
        if (updatedComparativo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedComparativo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        comparativoPreciosCompraService.delete(id);
        return ResponseEntity.noContent().build();
    }
}