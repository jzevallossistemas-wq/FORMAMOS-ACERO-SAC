package com.example.demo.controller;

import com.example.demo.entity.Orden;
import com.example.demo.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

    // Create a new Orden
    @PostMapping
    public ResponseEntity<Orden> createOrden(@RequestBody Orden orden) {
        Orden newOrden = ordenService.save(orden);
        return ResponseEntity.ok(newOrden);
    }

    // Get an Orden by ID
    @GetMapping("/{id}")
    public ResponseEntity<Orden> getOrdenById(@PathVariable Long id) {
        Orden orden = ordenService.findById(id);
        return ResponseEntity.ok(orden);
    }

    // Get all Ordenes
    @GetMapping
    public ResponseEntity<List<Orden>> getAllOrdenes() {
        List<Orden> ordenes = ordenService.findAll();
        return ResponseEntity.ok(ordenes);
    }

    // Update an Orden
    @PutMapping("/{id}")
    public ResponseEntity<Orden> updateOrden(@PathVariable Long id, @RequestBody Orden ordenDetails) {
        Orden updatedOrden = ordenService.update(id, ordenDetails);
        return ResponseEntity.ok(updatedOrden);
    }

    // Delete an Orden
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrden(@PathVariable Long id) {
        ordenService.delete(id);
        return ResponseEntity.noContent().build();
    }
}