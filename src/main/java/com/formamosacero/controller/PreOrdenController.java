package com.formamosacero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/preorden")
public class PreOrdenController {

    @GetMapping
    public String listarPreOrdenes(Model model) {
        model.addAttribute("titulo", "Listado de Pre-Órdenes");
        return "preorden/list";
    }

    @GetMapping("/nuevo")
    public String crearPreOrden(Model model) {
        model.addAttribute("titulo", "Crear Pre-Orden");
        return "preorden/create";
    }

    @PostMapping("/guardar")
    public String guardarPreOrden(@RequestParam String numero, Model model) {
        model.addAttribute("mensaje", "Pre-Orden guardada correctamente");
        return "redirect:/preorden";
    }

    @GetMapping("/{id}/editar")
    public String editarPreOrden(@PathVariable Long id, Model model) {
        model.addAttribute("titulo", "Editar Pre-Orden");
        model.addAttribute("id", id);
        return "preorden/edit";
    }

    @PostMapping("/actualizar")
    public String actualizarPreOrden(@RequestParam Long id, @RequestParam String numero) {
        return "redirect:/preorden";
    }

    @DeleteMapping("/{id}")
    public String eliminarPreOrden(@PathVariable Long id) {
        return "redirect:/preorden";
    }
}