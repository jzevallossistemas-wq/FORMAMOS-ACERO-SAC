package com.formamosacero.controller;

import com.formamosacero.models.PreOrden;
import com.formamosacero.services.PreOrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/preorden")
public class PreOrdenController {

    @Autowired
    private PreOrdenService preOrdenService;

    @GetMapping
    public String listar(Model model) {
        List<PreOrden> preOrdenes = preOrdenService.obtenerTodos();
        model.addAttribute("preOrdenes", preOrdenes);
        return "preorden/lista";
    }

    @GetMapping("/new")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("preOrden", new PreOrden());
        return "preorden/formulario";
    }

    @PostMapping
    public String guardar(@ModelAttribute PreOrden preOrden, RedirectAttributes redirectAttributes) {
        preOrdenService.guardar(preOrden);
        redirectAttributes.addFlashAttribute("mensaje", "Pre-Orden guardada exitosamente");
        return "redirect:/preorden";
    }

    @GetMapping("/{id}")
    public String ver(@PathVariable Long id, Model model) {
        Optional<PreOrden> preOrden = preOrdenService.obtenerPorId(id);
        if (preOrden.isPresent()) {
            model.addAttribute("preOrden", preOrden.get());
            return "preorden/detalle";
        }
        return "redirect:/preorden";
    }

    @GetMapping("/{id}/edit")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Optional<PreOrden> preOrden = preOrdenService.obtenerPorId(id);
        if (preOrden.isPresent()) {
            model.addAttribute("preOrden", preOrden.get());
            return "preorden/formulario";
        }
        return "redirect:/preorden";
    }

    @PostMapping("/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute PreOrden preOrden, RedirectAttributes redirectAttributes) {
        PreOrden preOrdenActualizado = preOrdenService.actualizar(id, preOrden);
        if (preOrdenActualizado != null) {
            redirectAttributes.addFlashAttribute("mensaje", "Pre-Orden actualizada exitosamente");
        } else {
            redirectAttributes.addFlashAttribute("error", "Pre-Orden no encontrada");
        }
        return "redirect:/preorden";
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String eliminar(@PathVariable Long id) {
        try {
            preOrdenService.eliminar(id);
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
        List<PreOrden> preOrdenes;
        
        if (numero != null && !numero.isEmpty()) {
            PreOrden preOrden = preOrdenService.buscarPorNumero(numero);
            preOrdenes = preOrden != null ? List.of(preOrden) : List.of();
        } else if (estado != null && !estado.isEmpty()) {
            preOrdenes = preOrdenService.buscarPorEstado(estado);
        } else if (fechaInicio != null && !fechaInicio.isEmpty() && fechaFin != null && !fechaFin.isEmpty()) {
            preOrdenes = preOrdenService.buscarPorRangoFechas(LocalDate.parse(fechaInicio), LocalDate.parse(fechaFin));
        } else {
            preOrdenes = preOrdenService.obtenerTodos();
        }
        
        model.addAttribute("preOrdenes", preOrdenes);
        return "preorden/lista";
    }
}
