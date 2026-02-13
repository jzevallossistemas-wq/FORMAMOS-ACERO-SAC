package com.formamosacero.controller;

import com.formamosacero.models.CotizacionPasajes;
import com.formamosacero.services.CotizacionPasajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cotizacionpasajes")
public class CotizacionPasajesController {
    
    @Autowired
    private CotizacionPasajesService cotizacionService;
    
    @GetMapping
    public String listar(Model model, 
                        @RequestParam(required = false) String buscar,
                        @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<CotizacionPasajes> cotizacionesPage = cotizacionService.obtenerTodos(pageable);
        
        model.addAttribute("items", cotizacionesPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", cotizacionesPage.getTotalPages());
        model.addAttribute("totalItems", cotizacionesPage.getTotalElements());
        model.addAttribute("buscar", buscar);
        
        return "cotizacionpasajes/lista";
    }
    
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("cotizacion", new CotizacionPasajes());
        model.addAttribute("esNuevo", true);
        return "cotizacionpasajes/formulario";
    }
    
    @PostMapping
    public String guardar(@ModelAttribute CotizacionPasajes cotizacion, RedirectAttributes redirectAttributes) {
        try {
            cotizacionService.guardar(cotizacion);
            redirectAttributes.addFlashAttribute("mensaje", "Cotización guardada exitosamente");
            redirectAttributes.addFlashAttribute("tipoMensaje", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al guardar cotización: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipoMensaje", "error");
        }
        return "redirect:/cotizacionpasajes";
    }
    
    @GetMapping("/{id}/editar")
    public String editar(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        CotizacionPasajes cotizacion = cotizacionService.obtenerPorId(id).orElse(null);
        if (cotizacion == null) {
            redirectAttributes.addFlashAttribute("mensaje", "Cotización no encontrada");
            redirectAttributes.addFlashAttribute("tipoMensaje", "error");
            return "redirect:/cotizacionpasajes";
        }
        model.addAttribute("cotizacion", cotizacion);
        model.addAttribute("esNuevo", false);
        return "cotizacionpasajes/formulario";
    }
    
    @PostMapping("/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute CotizacionPasajes cotizacion, RedirectAttributes redirectAttributes) {
        try {
            CotizacionPasajes actualizado = cotizacionService.actualizar(id, cotizacion);
            if (actualizado != null) {
                redirectAttributes.addFlashAttribute("mensaje", "Cotización actualizada exitosamente");
                redirectAttributes.addFlashAttribute("tipoMensaje", "success");
            } else {
                redirectAttributes.addFlashAttribute("mensaje", "Cotización no encontrada");
                redirectAttributes.addFlashAttribute("tipoMensaje", "error");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al actualizar cotización: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipoMensaje", "error");
        }
        return "redirect:/cotizacionpasajes";
    }
    
    @GetMapping("/{id}/eliminar")
    public String eliminar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            cotizacionService.eliminar(id);
            redirectAttributes.addFlashAttribute("mensaje", "Cotización eliminada exitosamente");
            redirectAttributes.addFlashAttribute("tipoMensaje", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al eliminar cotización: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipoMensaje", "error");
        }
        return "redirect:/cotizacionpasajes";
    }
}
