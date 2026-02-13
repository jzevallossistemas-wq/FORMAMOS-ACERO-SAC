package com.formamosacero.controller;

import com.formamosacero.models.Proveedor;
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
@RequestMapping("/proveedor")
public class ProveedorController {
    
    @Autowired
    private ProveedorService proveedorService;
    
    @GetMapping
    public String listar(Model model, 
                        @RequestParam(required = false) String buscar,
                        @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Proveedor> proveedoresPage = proveedorService.obtenerTodos(pageable);
        
        model.addAttribute("items", proveedoresPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", proveedoresPage.getTotalPages());
        model.addAttribute("totalItems", proveedoresPage.getTotalElements());
        model.addAttribute("buscar", buscar);
        
        return "proveedor/lista";
    }
    
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        model.addAttribute("esNuevo", true);
        return "proveedor/formulario";
    }
    
    @PostMapping
    public String guardar(@ModelAttribute Proveedor proveedor, RedirectAttributes redirectAttributes) {
        try {
            proveedorService.guardar(proveedor);
            redirectAttributes.addFlashAttribute("mensaje", "Proveedor guardado exitosamente");
            redirectAttributes.addFlashAttribute("tipoMensaje", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al guardar proveedor: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipoMensaje", "error");
        }
        return "redirect:/proveedor";
    }
    
    @GetMapping("/{id}/editar")
    public String editar(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Proveedor proveedor = proveedorService.obtenerPorId(id).orElse(null);
        if (proveedor == null) {
            redirectAttributes.addFlashAttribute("mensaje", "Proveedor no encontrado");
            redirectAttributes.addFlashAttribute("tipoMensaje", "error");
            return "redirect:/proveedor";
        }
        model.addAttribute("proveedor", proveedor);
        model.addAttribute("esNuevo", false);
        return "proveedor/formulario";
    }
    
    @PostMapping("/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute Proveedor proveedor, RedirectAttributes redirectAttributes) {
        try {
            Proveedor actualizado = proveedorService.actualizar(id, proveedor);
            if (actualizado != null) {
                redirectAttributes.addFlashAttribute("mensaje", "Proveedor actualizado exitosamente");
                redirectAttributes.addFlashAttribute("tipoMensaje", "success");
            } else {
                redirectAttributes.addFlashAttribute("mensaje", "Proveedor no encontrado");
                redirectAttributes.addFlashAttribute("tipoMensaje", "error");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al actualizar proveedor: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipoMensaje", "error");
        }
        return "redirect:/proveedor";
    }
    
    @GetMapping("/{id}/eliminar")
    public String eliminar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            proveedorService.eliminar(id);
            redirectAttributes.addFlashAttribute("mensaje", "Proveedor eliminado exitosamente");
            redirectAttributes.addFlashAttribute("tipoMensaje", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al eliminar proveedor: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipoMensaje", "error");
        }
        return "redirect:/proveedor";
    }
}
