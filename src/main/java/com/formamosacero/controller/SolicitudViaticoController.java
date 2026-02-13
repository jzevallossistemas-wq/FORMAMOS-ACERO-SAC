package com.formamosacero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.formamosacero.model.SolicitudViatico;
import com.formamosacero.repository.SolicitudViaticoRepository;

@RestController
@RequestMapping("/api/solicitud-viaticos")
public class SolicitudViaticoController {

    @Autowired
    private SolicitudViaticoRepository repository;

    // CREATE
    @PostMapping
    public SolicitudViatico createSolicitudViatico(@RequestBody SolicitudViatico solicitudViatico) {
        return repository.save(solicitudViatico);
    }

    // READ by ID
    @GetMapping("/{id}")
    public ResponseEntity<SolicitudViatico> getSolicitudViaticoById(@PathVariable Long id) {
        SolicitudViatico solicitudViatico = repository.findById(id).orElse(null);
        return ResponseEntity.ok(solicitudViatico);
    }

    // READ all
    @GetMapping
    public List<SolicitudViatico> getAllSolicitudViaticos() {
        return repository.findAll();
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<SolicitudViatico> updateSolicitudViatico(@PathVariable Long id, 
                                           @RequestBody SolicitudViatico solicitudViaticoDetails) {
        SolicitudViatico solicitudViatico = repository.findById(id).orElse(null);
        if (solicitudViatico != null) {
            solicitudViatico.setField1(solicitudViaticoDetails.getField1());
            // Set other fields as needed
            return ResponseEntity.ok(repository.save(solicitudViatico));
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSolicitudViatico(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}