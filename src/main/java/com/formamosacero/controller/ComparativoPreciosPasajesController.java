package com.formamosacero.controller;

import com.formamosacero.model.ComparativoPreciosPasajes;
import com.formamosacero.repository.ComparativoPreciosPasajesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comparativo-precios-pasajes")
public class ComparativoPreciosPasajesController {

    @Autowired
    private ComparativoPreciosPasajesRepository repository;

    @GetMapping
    public List<ComparativoPreciosPasajes> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComparativoPreciosPasajes> getById(@PathVariable(value = "id") Long id) {
        ComparativoPreciosPasajes comparativo = repository.findById(id).orElse(null);
        return new ResponseEntity<>(comparativo, comparativo != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ComparativoPreciosPasajes> create(@RequestBody ComparativoPreciosPasajes comparativo) {
        return new ResponseEntity<>(repository.save(comparativo), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComparativoPreciosPasajes> update(@PathVariable(value = "id") Long id,
                                                             @RequestBody ComparativoPreciosPasajes comparativoDetails) {
        ComparativoPreciosPasajes comparativo = repository.findById(id).orElse(null);
        if (comparativo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        comparativo.setField1(comparativoDetails.getField1()); // update fields accordingly
        // Add other field updates here
        return new ResponseEntity<>(repository.save(comparativo), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(value = "id") Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}