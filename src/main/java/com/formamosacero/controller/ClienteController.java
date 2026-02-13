package com.formamosacero.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    // GET mapping for listing clients
    @GetMapping
    public List<Cliente> listarClientes() {
        // Logic for listing clients goes here
        return null;
    }

    // POST mapping for creating a client
    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        // Logic for creating a client goes here
        return null;
    }

    // GET mapping for editing a client
    @GetMapping("/{id}")
    public Cliente editarCliente(@PathVariable Long id) {
        // Logic for retrieving a client for editing goes here
        return null;
    }

    // POST mapping for updating a client
    @PostMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        // Logic for updating a client goes here
        return null;
    }
}
