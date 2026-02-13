package com.formamosacero.controller;

import com.formamosacero.models.SolicitudEfectivo;
import com.formamosacero.services.SolicitudEfectivoService;
import com.formamosacero.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/solicitudefectivo")
public class SolicitudEfectivoController {
    
    @Autowired
    private SolicitudEfectivoService solicitudService;
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping
    public String listar(Model model, 
                        @RequestParam(required = false) String buscar,
                        @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<SolicitudEfectivo> solicitudesPage = solicitudService.obtenerTodos(pageable);
        
        model.addAttribute("items", solicitudesPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", solicitudesPage.getTotalPages());
        model.addAttribute("totalItems", solicitudesPage.getTotalElements());
        model.addAttribute("buscar", buscar);
        
        return "solicitudefectivo/lista";
    }
    
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("solicitud", new SolicitudEfectivo());
        model.addAttribute("esNuevo", true);
        model.addAttribute("clientes", clienteService.obtenerTodos());
        return "solicitudefectivo/formulario";
    }
    
    @PostMapping
    public String guardar(@ModelAttribute SolicitudEfectivo solicitud, RedirectAttributes redirectAttributes) {
        try {
            solicitudService.guardar(solicitud);
            redirectAttributes.addFlashAttribute("mensaje", "Solicitud guardada exitosamente");
            redirectAttributes.addFlashAttribute("tipoMensaje", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al guardar solicitud: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipoMensaje", "error");
        }
        return "redirect:/solicitudefectivo";
    }
    
    @GetMapping("/{id}/editar")
    public String editar(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        SolicitudEfectivo solicitud = solicitudService.obtenerPorId(id).orElse(null);
        if (solicitud == null) {
            redirectAttributes.addFlashAttribute("mensaje", "Solicitud no encontrada");
            redirectAttributes.addFlashAttribute("tipoMensaje", "error");
            return "redirect:/solicitudefectivo";
        }
        model.addAttribute("solicitud", solicitud);
        model.addAttribute("esNuevo", false);
        model.addAttribute("clientes", clienteService.obtenerTodos());
        return "solicitudefectivo/formulario";
    }
    
    @PostMapping("/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute SolicitudEfectivo solicitud, RedirectAttributes redirectAttributes) {
        try {
            SolicitudEfectivo actualizado = solicitudService.actualizar(id, solicitud);
            if (actualizado != null) {
                redirectAttributes.addFlashAttribute("mensaje", "Solicitud actualizada exitosamente");
                redirectAttributes.addFlashAttribute("tipoMensaje", "success");
            } else {
                redirectAttributes.addFlashAttribute("mensaje", "Solicitud no encontrada");
                redirectAttributes.addFlashAttribute("tipoMensaje", "error");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al actualizar solicitud: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipoMensaje", "error");
        }
        return "redirect:/solicitudefectivo";
    }
    
    @GetMapping("/{id}/eliminar")
    public String eliminar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            solicitudService.eliminar(id);
            redirectAttributes.addFlashAttribute("mensaje", "Solicitud eliminada exitosamente");
            redirectAttributes.addFlashAttribute("tipoMensaje", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al eliminar solicitud: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipoMensaje", "error");
        }
        return "redirect:/solicitudefectivo";
    }
}
