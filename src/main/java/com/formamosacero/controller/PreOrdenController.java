package com.formamosacero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/preorden")
public class PreOrdenController {

    @GetMapping
    public String list(Model model) {
        model.addAttribute("preordenes", List.of());
        return "preorden/list";
    }

    @GetMapping("/nuevo")
    public String showCreateForm(Model model) {
        model.addAttribute("preorden", new PreOrden());
        return "preorden/create";
    }

    @PostMapping
    public String save(@ModelAttribute PreOrden preorden) {
        return "redirect:/preorden";
    }

    @GetMapping("/{id}/editar")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("preorden", new PreOrden());
        return "preorden/edit";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute PreOrden preorden) {
        return "redirect:/preorden";
    }

    @GetMapping("/{id}/eliminar")
    public String delete(@PathVariable Long id) {
        return "redirect:/preorden";
    }
}
