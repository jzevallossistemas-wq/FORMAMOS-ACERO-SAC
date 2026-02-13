package com.example.demo.controller;

import com.example.demo.entity.ComparativoPrecioPasajes;
import com.example.demo.repository.ComparativoPrecioPasajesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comparativo-precio-pasajes")
public class ComparativoPrecioPasajesController {

    @Autowired
    private ComparativoPrecioPasajesRepository repository;

    @GetMapping
    public List<ComparativoPrecioPasajes> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComparativoPrecioPasajes> getById(@PathVariable Long id) {
        ComparativoPrecioPasajes comparativoPrecioPasajes = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ComparativoPrecioPasajes not found with id " + id));
        return ResponseEntity.ok(comparativoPrecioPasajes);
    }

    @PostMapping
    public ComparativoPrecioPasajes create(@RequestBody ComparativoPrecioPasajes comparativoPrecioPasajes) {
        return repository.save(comparativoPrecioPasajes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComparativoPrecioPasajes> update(@PathVariable Long id, @RequestBody ComparativoPrecioPasajes comparativoPrecioPasajesDetails) {
        ComparativoPrecioPasajes comparativoPrecioPasajes = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ComparativoPrecioPasajes not found with id " + id));
        
        comparativoPrecioPasajes.setField1(comparativoPrecioPasajesDetails.getField1());
        comparativoPrecioPasajes.setField2(comparativoPrecioPasajesDetails.getField2());
        // Set other fields as necessary

        final ComparativoPrecioPasajes updatedComparativoPrecioPasajes = repository.save(comparativoPrecioPasajes);
        return ResponseEntity.ok(updatedComparativoPrecioPasajes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ComparativoPrecioPasajes comparativoPrecioPasajes = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ComparativoPrecioPasajes not found with id " + id));
        repository.delete(comparativoPrecioPasajes);
        return ResponseEntity.noContent().build();
    }
}
