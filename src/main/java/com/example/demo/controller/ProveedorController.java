package com.example.demo.controller;

import com.example.demo.model.Proveedor;
import com.example.demo.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public List<Proveedor> getAllProveedores() {
        return proveedorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> getProveedorById(@PathVariable Long id) {
        Proveedor proveedor = proveedorService.findById(id);
        return proveedor != null ? new ResponseEntity<>(proveedor, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Proveedor> createProveedor(@RequestBody Proveedor proveedor) {
        Proveedor createdProveedor = proveedorService.save(proveedor);
        return new ResponseEntity<>(createdProveedor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> updateProveedor(@PathVariable Long id, @RequestBody Proveedor proveedor) {
        Proveedor updatedProveedor = proveedorService.update(id, proveedor);
        return updatedProveedor != null ? new ResponseEntity<>(updatedProveedor, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProveedor(@PathVariable Long id) {
        proveedorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}