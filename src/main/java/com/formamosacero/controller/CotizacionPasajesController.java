package com.formamosacero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cotizacion-pasajes")
public class CotizacionPasajesController {

    @Autowired
    private CotizacionPasajesService cotizacionPasajesService;

    // Create a new CotizacionPasajes
    @PostMapping
    public ResponseEntity<CotizacionPasajes> createCotizacionPasajes(@RequestBody CotizacionPasajes cotizacionPasajes) {
        CotizacionPasajes created = cotizacionPasajesService.create(cotizacionPasajes);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // Get all CotizacionPasajes
    @GetMapping
    public ResponseEntity<List<CotizacionPasajes>> getAllCotizacionPasajes() {
        List<CotizacionPasajes> list = cotizacionPasajesService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // Get a single CotizacionPasajes by id
    @GetMapping("/{id}")
    public ResponseEntity<CotizacionPasajes> getCotizacionPasajesById(@PathVariable Long id) {
        CotizacionPasajes cotizacionPasajes = cotizacionPasajesService.getById(id);
        return cotizacionPasajes != null ? new ResponseEntity<>(cotizacionPasajes, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Update a CotizacionPasajes
    @PutMapping("/{id}")
    public ResponseEntity<CotizacionPasajes> updateCotizacionPasajes(@PathVariable Long id, @RequestBody CotizacionPasajes cotizacionPasajes) {
        CotizacionPasajes updated = cotizacionPasajesService.update(id, cotizacionPasajes);
        return updated != null ? new ResponseEntity<>(updated, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete a CotizacionPasajes
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCotizacionPasajes(@PathVariable Long id) {
        if (cotizacionPasajesService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}