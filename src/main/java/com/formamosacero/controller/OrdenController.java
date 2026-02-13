package com.formamosacero.controller;

import com.formamosacero.models.OrdenCompra;
import com.formamosacero.services.OrdenService;
import com.formamosacero.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/orden")
public class OrdenController {
    
    @Autowired
    private OrdenService ordenService;
    
    @Autowired
    private ProveedorService proveedorService;
    
    @GetMapping
    public String listar(Model model, 
                        @RequestParam(required = false) String buscar,
                        @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<OrdenCompra> ordenesPage = ordenService.obtenerTodos(pageable);
        
        model.addAttribute("items", ordenesPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", ordenesPage.getTotalPages());
        model.addAttribute("totalItems", ordenesPage.getTotalElements());
        model.addAttribute("buscar", buscar);
        
        return "orden/lista";
    }
    
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("orden", new OrdenCompra());
        model.addAttribute("esNuevo", true);
        model.addAttribute("proveedores", proveedorService.obtenerTodos());
        return "orden/formulario";
    }
    
    @PostMapping
    public String guardar(@ModelAttribute OrdenCompra orden, RedirectAttributes redirectAttributes) {
        try {
            ordenService.guardar(orden);
            redirectAttributes.addFlashAttribute("mensaje", "Orden guardada exitosamente");
            redirectAttributes.addFlashAttribute("tipoMensaje", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al guardar orden: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipoMensaje", "error");
        }
        return "redirect:/orden";
    }
    
    @GetMapping("/{id}/editar")
    public String editar(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        OrdenCompra orden = ordenService.obtenerPorId(id).orElse(null);
        if (orden == null) {
            redirectAttributes.addFlashAttribute("mensaje", "Orden no encontrada");
            redirectAttributes.addFlashAttribute("tipoMensaje", "error");
            return "redirect:/orden";
        }
        model.addAttribute("orden", orden);
        model.addAttribute("esNuevo", false);
        model.addAttribute("proveedores", proveedorService.obtenerTodos());
        return "orden/formulario";
    }
    
    @PostMapping("/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute OrdenCompra orden, RedirectAttributes redirectAttributes) {
        try {
            OrdenCompra actualizado = ordenService.actualizar(id, orden);
            if (actualizado != null) {
                redirectAttributes.addFlashAttribute("mensaje", "Orden actualizada exitosamente");
                redirectAttributes.addFlashAttribute("tipoMensaje", "success");
            } else {
                redirectAttributes.addFlashAttribute("mensaje", "Orden no encontrada");
                redirectAttributes.addFlashAttribute("tipoMensaje", "error");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al actualizar orden: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipoMensaje", "error");
        }
        return "redirect:/orden";
    }
    
    @GetMapping("/{id}/eliminar")
    public String eliminar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            ordenService.eliminar(id);
            redirectAttributes.addFlashAttribute("mensaje", "Orden eliminada exitosamente");
            redirectAttributes.addFlashAttribute("tipoMensaje", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al eliminar orden: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipoMensaje", "error");
        }
        return "redirect:/orden";
    }
}
