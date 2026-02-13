package com.formamosacero.controller;

import com.formamosacero.models.ComparativoPreciosPasajes;
import com.formamosacero.services.ComparativoPreciosPasajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/comparativo-precios-pasajes")
public class ComparativoPreciosPasajesController {

    @Autowired
    private ComparativoPreciosPasajesService comparativoPreciosPasajesService;

    @GetMapping
    public String listar(Model model) {
        List<ComparativoPreciosPasajes> comparativos = comparativoPreciosPasajesService.obtenerTodos();
        model.addAttribute("comparativos", comparativos);
        return "comparativoPreciosPasajes/lista";
    }

    @GetMapping("/new")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("comparativoPreciosPasajes", new ComparativoPreciosPasajes());
        return "comparativoPreciosPasajes/formulario";
    }

    @PostMapping
    public String guardar(@ModelAttribute ComparativoPreciosPasajes comparativoPreciosPasajes, RedirectAttributes redirectAttributes) {
        comparativoPreciosPasajesService.guardar(comparativoPreciosPasajes);
        redirectAttributes.addFlashAttribute("mensaje", "Comparativo de Precios de Pasajes guardado exitosamente");
        return "redirect:/comparativo-precios-pasajes";
    }

    @GetMapping("/{id}")
    public String ver(@PathVariable Long id, Model model) {
        Optional<ComparativoPreciosPasajes> comparativoPreciosPasajes = comparativoPreciosPasajesService.obtenerPorId(id);
        if (comparativoPreciosPasajes.isPresent()) {
            model.addAttribute("comparativoPreciosPasajes", comparativoPreciosPasajes.get());
            return "comparativoPreciosPasajes/detalle";
        }
        return "redirect:/comparativo-precios-pasajes";
    }

    @GetMapping("/{id}/edit")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Optional<ComparativoPreciosPasajes> comparativoPreciosPasajes = comparativoPreciosPasajesService.obtenerPorId(id);
        if (comparativoPreciosPasajes.isPresent()) {
            model.addAttribute("comparativoPreciosPasajes", comparativoPreciosPasajes.get());
            return "comparativoPreciosPasajes/formulario";
        }
        return "redirect:/comparativo-precios-pasajes";
    }

    @PostMapping("/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute ComparativoPreciosPasajes comparativoPreciosPasajes, RedirectAttributes redirectAttributes) {
        ComparativoPreciosPasajes comparativoActualizado = comparativoPreciosPasajesService.actualizar(id, comparativoPreciosPasajes);
        if (comparativoActualizado != null) {
            redirectAttributes.addFlashAttribute("mensaje", "Comparativo de Precios de Pasajes actualizado exitosamente");
        } else {
            redirectAttributes.addFlashAttribute("error", "Comparativo de Precios de Pasajes no encontrado");
        }
        return "redirect:/comparativo-precios-pasajes";
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String eliminar(@PathVariable Long id) {
        try {
            comparativoPreciosPasajesService.eliminar(id);
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
        List<ComparativoPreciosPasajes> comparativos;
        
        if (numero != null && !numero.isEmpty()) {
            ComparativoPreciosPasajes comparativo = comparativoPreciosPasajesService.buscarPorNumero(numero);
            comparativos = comparativo != null ? List.of(comparativo) : List.of();
        } else if (estado != null && !estado.isEmpty()) {
            comparativos = comparativoPreciosPasajesService.buscarPorEstado(estado);
        } else if (fechaInicio != null && !fechaInicio.isEmpty() && fechaFin != null && !fechaFin.isEmpty()) {
            comparativos = comparativoPreciosPasajesService.buscarPorRangoFechas(LocalDate.parse(fechaInicio), LocalDate.parse(fechaFin));
        } else {
            comparativos = comparativoPreciosPasajesService.obtenerTodos();
        }
        
        model.addAttribute("comparativos", comparativos);
        return "comparativoPreciosPasajes/lista";
    }
}
