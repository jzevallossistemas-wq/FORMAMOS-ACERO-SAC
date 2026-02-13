package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @GetMapping("/list")
    public String listClientes(Model model) {
        // TODO: Implementar lógica para obtener lista de clientes
        return "cliente/list";
    }

    @GetMapping("/create")
    public String createClienteForm(Model model) {
        return "cliente/create";
    }

    @PostMapping("/create")
    public String createCliente(Model model) {
        // TODO: Implementar lógica para crear cliente
        return "redirect:/cliente/list";
    }

    @GetMapping("/edit/{id}")
    public String editClienteForm(Long id, Model model) {
        // TODO: Implementar lógica para obtener cliente por ID
        return "cliente/edit";
    }

    @PostMapping("/update")
    public String updateCliente(Model model) {
        // TODO: Implementar lógica para actualizar cliente
        return "redirect:/cliente/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteCliente(Long id) {
        // TODO: Implementar lógica para eliminar cliente
        return "redirect:/cliente/list";
    }
}