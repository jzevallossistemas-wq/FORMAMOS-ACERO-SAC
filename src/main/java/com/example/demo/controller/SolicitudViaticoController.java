package com.example.demo.controller;

import com.example.demo.model.SolicitudViatico;
import com.example.demo.service.SolicitudViaticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitud-viatico")
public class SolicitudViaticoController {

    @Autowired
    private SolicitudViaticoService solicitudViaticoService;

    @PostMapping
    public ResponseEntity<SolicitudViatico> createSolicitudViatico(@RequestBody SolicitudViatico solicitudViatico) {
        SolicitudViatico created = solicitudViaticoService.createSolicitudViatico(solicitudViatico);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudViatico> getSolicitudViatico(@PathVariable Long id) {
        SolicitudViatico solicitudViatico = solicitudViaticoService.getSolicitudViaticoById(id);
        return new ResponseEntity<>(solicitudViatico, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SolicitudViatico>> getAllSolicitudViaticos() {
        List<SolicitudViatico> solicitudViaticos = solicitudViaticoService.getAllSolicitudViaticos();
        return new ResponseEntity<>(solicitudViaticos, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SolicitudViatico> updateSolicitudViatico(@PathVariable Long id, @RequestBody SolicitudViatico solicitudViatico) {
        SolicitudViatico updated = solicitudViaticoService.updateSolicitudViatico(id, solicitudViatico);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSolicitudViatico(@PathVariable Long id) {
        solicitudViaticoService.deleteSolicitudViatico(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}