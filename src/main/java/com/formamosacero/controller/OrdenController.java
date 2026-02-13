package com.formamosacero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orden")
public class OrdenController {

    @GetMapping
    public String listarOrdenes(Model model) {
        model.addAttribute("titulo", "Listado de Órdenes");
        return "orden/list";
    }

    @GetMapping("/nuevo")
    public String crearOrden(Model model) {
        model.addAttribute("titulo", "Crear Orden");
        return "orden/create";
    }

    @PostMapping("/guardar")
    public String guardarOrden(@RequestParam String numero, Model model) {
        model.addAttribute("mensaje", "Orden guardada correctamente");
        return "redirect:/orden";
    }

    @GetMapping("/{id}/editar")
    public String editarOrden(@PathVariable Long id, Model model) {
        model.addAttribute("titulo", "Editar Orden");
        model.addAttribute("id", id);
        return "orden/edit";
    }

    @PostMapping("/actualizar")
    public String actualizarOrden(@RequestParam Long id, @RequestParam String numero) {
        return "redirect:/orden";
    }

    @DeleteMapping("/{id}")
    public String eliminarOrden(@PathVariable Long id) {
        return "redirect:/orden";
    }
}