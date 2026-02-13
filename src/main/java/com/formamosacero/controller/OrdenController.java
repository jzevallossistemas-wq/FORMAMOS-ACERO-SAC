package com.formamosacero.controller;

import com.formamosacero.models.Orden;
import com.formamosacero.services.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/orden")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

    @GetMapping
    public String listar(Model model) {
        List<Orden> ordenes = ordenService.obtenerTodos();
        model.addAttribute("ordenes", ordenes);
        return "orden/lista";
    }

    @GetMapping("/new")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("orden", new Orden());
        return "orden/formulario";
    }

    @PostMapping
    public String guardar(@ModelAttribute Orden orden, RedirectAttributes redirectAttributes) {
        ordenService.guardar(orden);
        redirectAttributes.addFlashAttribute("mensaje", "Orden guardada exitosamente");
        return "redirect:/orden";
    }

    @GetMapping("/{id}")
    public String ver(@PathVariable Long id, Model model) {
        Optional<Orden> orden = ordenService.obtenerPorId(id);
        if (orden.isPresent()) {
            model.addAttribute("orden", orden.get());
            return "orden/detalle";
        }
        return "redirect:/orden";
    }

    @GetMapping("/{id}/edit")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Optional<Orden> orden = ordenService.obtenerPorId(id);
        if (orden.isPresent()) {
            model.addAttribute("orden", orden.get());
            return "orden/formulario";
        }
        return "redirect:/orden";
    }

    @PostMapping("/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute Orden orden, RedirectAttributes redirectAttributes) {
        Orden ordenActualizado = ordenService.actualizar(id, orden);
        if (ordenActualizado != null) {
            redirectAttributes.addFlashAttribute("mensaje", "Orden actualizada exitosamente");
        } else {
            redirectAttributes.addFlashAttribute("error", "Orden no encontrada");
        }
        return "redirect:/orden";
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String eliminar(@PathVariable Long id) {
        try {
            ordenService.eliminar(id);
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/search")
    public String buscar(@RequestParam(required = false) String numero,
                        @RequestParam(required = false) String estado,
                        @RequestParam(required = false) String fechaInicio,
                        @RequestParam(required = false) String fechaFin,
                        Model model) {
        List<Orden> ordenes;
        
        if (numero != null && !numero.isEmpty()) {
            Orden orden = ordenService.buscarPorNumero(numero);
            ordenes = orden != null ? List.of(orden) : List.of();
        } else if (estado != null && !estado.isEmpty()) {
            ordenes = ordenService.buscarPorEstado(estado);
        } else if (fechaInicio != null && !fechaInicio.isEmpty() && fechaFin != null && !fechaFin.isEmpty()) {
            ordenes = ordenService.buscarPorRangoFechas(LocalDate.parse(fechaInicio), LocalDate.parse(fechaFin));
        } else {
            ordenes = ordenService.obtenerTodos();
        }
        
        model.addAttribute("ordenes", ordenes);
        return "orden/lista";
    }
}
