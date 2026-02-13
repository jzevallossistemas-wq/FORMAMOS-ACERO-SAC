package com.formamosacero.controller;

import com.formamosacero.models.PreOrden;
import com.formamosacero.services.PreOrdenService;
import com.formamosacero.services.ClienteService;
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
@RequestMapping("/preorden")
public class PreOrdenController {
    
    @Autowired
    private PreOrdenService preOrdenService;
    
    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    private ProveedorService proveedorService;
    
    @GetMapping
    public String listar(Model model, 
                        @RequestParam(required = false) String buscar,
                        @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<PreOrden> preOrdenesPage = preOrdenService.obtenerTodos(pageable);
        
        model.addAttribute("items", preOrdenesPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", preOrdenesPage.getTotalPages());
        model.addAttribute("totalItems", preOrdenesPage.getTotalElements());
        model.addAttribute("buscar", buscar);
        
        return "preorden/lista";
    }
    
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("preOrden", new PreOrden());
        model.addAttribute("esNuevo", true);
        model.addAttribute("clientes", clienteService.obtenerTodos());
        model.addAttribute("proveedores", proveedorService.obtenerTodos());
        return "preorden/formulario";
    }
    
    @PostMapping
    public String guardar(@ModelAttribute PreOrden preOrden, RedirectAttributes redirectAttributes) {
        try {
            preOrdenService.guardar(preOrden);
            redirectAttributes.addFlashAttribute("mensaje", "Pre Orden guardada exitosamente");
            redirectAttributes.addFlashAttribute("tipoMensaje", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al guardar pre orden: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipoMensaje", "error");
        }
        return "redirect:/preorden";
    }
    
    @GetMapping("/{id}/editar")
    public String editar(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        PreOrden preOrden = preOrdenService.obtenerPorId(id).orElse(null);
        if (preOrden == null) {
            redirectAttributes.addFlashAttribute("mensaje", "Pre Orden no encontrada");
            redirectAttributes.addFlashAttribute("tipoMensaje", "error");
            return "redirect:/preorden";
        }
        model.addAttribute("preOrden", preOrden);
        model.addAttribute("esNuevo", false);
        model.addAttribute("clientes", clienteService.obtenerTodos());
        model.addAttribute("proveedores", proveedorService.obtenerTodos());
        return "preorden/formulario";
    }
    
    @PostMapping("/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute PreOrden preOrden, RedirectAttributes redirectAttributes) {
        try {
            PreOrden actualizado = preOrdenService.actualizar(id, preOrden);
            if (actualizado != null) {
                redirectAttributes.addFlashAttribute("mensaje", "Pre Orden actualizada exitosamente");
                redirectAttributes.addFlashAttribute("tipoMensaje", "success");
            } else {
                redirectAttributes.addFlashAttribute("mensaje", "Pre Orden no encontrada");
                redirectAttributes.addFlashAttribute("tipoMensaje", "error");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al actualizar pre orden: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipoMensaje", "error");
        }
        return "redirect:/preorden";
    }
    
    @GetMapping("/{id}/eliminar")
    public String eliminar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            preOrdenService.eliminar(id);
            redirectAttributes.addFlashAttribute("mensaje", "Pre Orden eliminada exitosamente");
            redirectAttributes.addFlashAttribute("tipoMensaje", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al eliminar pre orden: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipoMensaje", "error");
        }
        return "redirect:/preorden";
    }
}
