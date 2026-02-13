package com.formamosacero.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {
    @GetMapping
    public String listarProveedores(Model model) {
        model.addAttribute("titulo", "Listado de Proveedores");
        return "proveedor/list";
    }

    @GetMapping("/nuevo")
    public String crearProveedor(Model model) {
        model.addAttribute("titulo", "Crear Proveedor");
        return "proveedor/create";
    }

    @PostMapping("/guardar")
    public String guardarProveedor(@RequestParam String nombre, Model model) {
        model.addAttribute("mensaje", "Proveedor guardado correctamente");
        return "redirect:/proveedor";
    }

    @GetMapping("/{id}/editar")
    public String editarProveedor(@PathVariable Long id, Model model) {
        model.addAttribute("titulo", "Editar Proveedor");
        model.addAttribute("id", id);
        return "proveedor/edit";
    }

    @PostMapping("/actualizar")
    public String actualizarProveedor(@RequestParam Long id, @RequestParam String nombre) {
        return "redirect:/proveedor";
    }

    @DeleteMapping("/{id}")
    public String eliminarProveedor(@PathVariable Long id) {
        return "redirect:/proveedor";
    }
}