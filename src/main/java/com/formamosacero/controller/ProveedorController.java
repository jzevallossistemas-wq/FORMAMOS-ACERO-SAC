package com.formamosacero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {

    // Dummy service for list of proveedores
    private List<String> proveedores = List.of("Proveedor1", "Proveedor2");

    @GetMapping
    public String listProveedores(Model model) {
        model.addAttribute("proveedores", proveedores);
        return "proveedor/list"; // Path to the list view
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("proveedor", new Proveedor()); // Assuming Proveedor is a model class
        return "proveedor/create"; // Path to the create form view
    }

    @PostMapping
    public String saveProveedor(@ModelAttribute Proveedor proveedor) {
        // Code to save the proveedor
        return "redirect:/proveedor"; // Redirect to the list
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        // Fetch the proveedor by id and add to model
        model.addAttribute("proveedor", proveedor);
        return "proveedor/edit"; // Path to the edit form view
    }

    @PostMapping("/update/{id}")
    public String updateProveedor(@PathVariable("id") Long id, @ModelAttribute Proveedor proveedor) {
        // Code to update the proveedor
        return "redirect:/proveedor"; // Redirect to the list
    }

    @GetMapping("/delete/{id}")
    public String deleteProveedor(@PathVariable("id") Long id) {
        // Code to delete proveedor
        return "redirect:/proveedor"; // Redirect to the list
    }
}