package com.example.demo.controller;

import com.example.demo.entity.SolicitudEfectivo;
import com.example.demo.service.SolicitudEfectivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudEfectivoController {

    @Autowired
    private SolicitudEfectivoService solicitudEfectivoService;

    // Create a new SolicitudEfectivo
    @PostMapping
    public SolicitudEfectivo createSolicitud(@RequestBody SolicitudEfectivo solicitudEfectivo) {
        return solicitudEfectivoService.createSolicitud(solicitudEfectivo);
    }

    // Get all SolicitudEfectivos
    @GetMapping
    public List<SolicitudEfectivo> getAllSolicitudes() {
        return solicitudEfectivoService.getAllSolicitudes();
    }

    // Get a single SolicitudEfectivo by ID
    @GetMapping("/{id}")
    public ResponseEntity<SolicitudEfectivo> getSolicitudById(@PathVariable Long id) {
        SolicitudEfectivo solicitudEfectivo = solicitudEfectivoService.getSolicitudById(id);
        if (solicitudEfectivo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(solicitudEfectivo);
    }

    // Update a SolicitudEfectivo
    @PutMapping("/{id}")
    public ResponseEntity<SolicitudEfectivo> updateSolicitud(@PathVariable Long id, @RequestBody SolicitudEfectivo solicitudEfectivo) {
        SolicitudEfectivo updatedSolicitud = solicitudEfectivoService.updateSolicitud(id, solicitudEfectivo);
        if (updatedSolicitud == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedSolicitud);
    }

    // Delete a SolicitudEfectivo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSolicitud(@PathVariable Long id) {
        if (solicitudEfectivoService.deleteSolicitud(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}