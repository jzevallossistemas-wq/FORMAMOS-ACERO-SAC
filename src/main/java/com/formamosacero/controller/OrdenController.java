package com.formamosacero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

    @GetMapping
    public List<Orden> getAllOrdenes() {
        return ordenService.getAllOrdenes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orden> getOrdenById(@PathVariable Long id) {
        Orden orden = ordenService.getOrdenById(id);
        if (orden != null) {
            return ResponseEntity.ok(orden);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Orden> createOrden(@RequestBody Orden orden) {
        Orden createdOrden = ordenService.createOrden(orden);
        return ResponseEntity.status(201).body(createdOrden);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orden> updateOrden(@PathVariable Long id, @RequestBody Orden ordenDetails) {
        Orden updatedOrden = ordenService.updateOrden(id, ordenDetails);
        if (updatedOrden != null) {
            return ResponseEntity.ok(updatedOrden);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrden(@PathVariable Long id) {
        if (ordenService.deleteOrden(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}