package com.formamosacero.controller;

import com.formamosacero.model.SolicitudEfectivo;
import com.formamosacero.service.SolicitudEfectivoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudEfectivoController {

    @Autowired
    private SolicitudEfectivoService solicitudEfectivoService;

    // Create a new SolicitudEfectivo
    @PostMapping
    public ResponseEntity<SolicitudEfectivo> createSolicitudEfectivo(@RequestBody SolicitudEfectivo solicitudEfectivo) {
        SolicitudEfectivo created = solicitudEfectivoService.create(solicitudEfectivo);
        return ResponseEntity.ok(created);
    }

    // Retrieve all SolicitudEfectivo entries
    @GetMapping
    public ResponseEntity<List<SolicitudEfectivo>> getAllSolicitudes() {
        List<SolicitudEfectivo> solicitudes = solicitudEfectivoService.findAll();
        return ResponseEntity.ok(solicitudes);
    }

    // Retrieve a single SolicitudEfectivo by ID
    @GetMapping("/{id}")
    public ResponseEntity<SolicitudEfectivo> getSolicitudEfectivoById(@PathVariable Long id) {
        SolicitudEfectivo solicitudEfectivo = solicitudEfectivoService.findById(id);
        return ResponseEntity.ok(solicitudEfectivo);
    }

    // Update an existing SolicitudEfectivo
    @PutMapping("/{id}")
    public ResponseEntity<SolicitudEfectivo> updateSolicitudEfectivo(@PathVariable Long id, @RequestBody SolicitudEfectivo solicitudEfectivo) {
        SolicitudEfectivo updated = solicitudEfectivoService.update(id, solicitudEfectivo);
        return ResponseEntity.ok(updated);
    }

    // Delete a SolicitudEfectivo by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSolicitudEfectivo(@PathVariable Long id) {
        solicitudEfectivoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}