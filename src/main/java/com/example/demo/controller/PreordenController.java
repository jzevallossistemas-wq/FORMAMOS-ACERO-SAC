package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/preorden")
public class PreordenController {

    @Autowired
    private PreordenService preordenService;

    @PostMapping
    public ResponseEntity<Preorden> createPreorden(@RequestBody Preorden preorden) {
        Preorden createdPreorden = preordenService.createPreorden(preorden);
        return ResponseEntity.ok(createdPreorden);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Preorden> getPreordenById(@PathVariable Long id) {
        Preorden preorden = preordenService.getPreordenById(id);
        return ResponseEntity.ok(preorden);
    }

    @GetMapping
    public ResponseEntity<List<Preorden>> getAllPreordenes() {
        List<Preorden> preordenes = preordenService.getAllPreordenes();
        return ResponseEntity.ok(preordenes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Preorden> updatePreorden(@PathVariable Long id, @RequestBody Preorden preorden) {
        Preorden updatedPreorden = preordenService.updatePreorden(id, preorden);
        return ResponseEntity.ok(updatedPreorden);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePreorden(@PathVariable Long id) {
        preordenService.deletePreorden(id);
        return ResponseEntity.noContent().build();
    }
}