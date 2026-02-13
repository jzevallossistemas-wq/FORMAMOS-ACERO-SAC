package com.formamosacero.controller;

import com.formamosacero.models.ComparativoPreciosPasajes;
import com.formamosacero.services.ComparativoPreciosPasajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/comparativopreciopasajes")
public class ComparativoPreciosPasajesController {
    
    @Autowired
    private ComparativoPreciosPasajesService comparativoService;
    
    @GetMapping
    public String listar(Model model, 
                        @RequestParam(required = false) String buscar,
                        @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<ComparativoPreciosPasajes> comparativosPage = comparativoService.obtenerTodos(pageable);
        
        model.addAttribute("items", comparativosPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", comparativosPage.getTotalPages());
        model.addAttribute("totalItems", comparativosPage.getTotalElements());
        model.addAttribute("buscar", buscar);
        
        return "comparativopreciopasajes/lista";
    }
    
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("comparativo", new ComparativoPreciosPasajes());
        model.addAttribute("esNuevo", true);
        return "comparativopreciopasajes/formulario";
    }
    
    @PostMapping
    public String guardar(@ModelAttribute ComparativoPreciosPasajes comparativo, RedirectAttributes redirectAttributes) {
        try {
            comparativoService.guardar(comparativo);
            redirectAttributes.addFlashAttribute("mensaje", "Comparativo guardado exitosamente");
            redirectAttributes.addFlashAttribute("tipoMensaje", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al guardar comparativo: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipoMensaje", "error");
        }
        return "redirect:/comparativopreciopasajes";
    }
    
    @GetMapping("/{id}/editar")
    public String editar(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        ComparativoPreciosPasajes comparativo = comparativoService.obtenerPorId(id).orElse(null);
        if (comparativo == null) {
            redirectAttributes.addFlashAttribute("mensaje", "Comparativo no encontrado");
            redirectAttributes.addFlashAttribute("tipoMensaje", "error");
            return "redirect:/comparativopreciopasajes";
        }
        model.addAttribute("comparativo", comparativo);
        model.addAttribute("esNuevo", false);
        return "comparativopreciopasajes/formulario";
    }
    
    @PostMapping("/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute ComparativoPreciosPasajes comparativo, RedirectAttributes redirectAttributes) {
        try {
            ComparativoPreciosPasajes actualizado = comparativoService.actualizar(id, comparativo);
            if (actualizado != null) {
                redirectAttributes.addFlashAttribute("mensaje", "Comparativo actualizado exitosamente");
                redirectAttributes.addFlashAttribute("tipoMensaje", "success");
            } else {
                redirectAttributes.addFlashAttribute("mensaje", "Comparativo no encontrado");
                redirectAttributes.addFlashAttribute("tipoMensaje", "error");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al actualizar comparativo: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipoMensaje", "error");
        }
        return "redirect:/comparativopreciopasajes";
    }
    
    @GetMapping("/{id}/eliminar")
    public String eliminar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            comparativoService.eliminar(id);
            redirectAttributes.addFlashAttribute("mensaje", "Comparativo eliminado exitosamente");
            redirectAttributes.addFlashAttribute("tipoMensaje", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al eliminar comparativo: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipoMensaje", "error");
        }
        return "redirect:/comparativopreciopasajes";
    }
}
