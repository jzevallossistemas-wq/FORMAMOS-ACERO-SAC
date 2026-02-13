package com.formamosacero.controller;

import com.formamosacero.models.CotizacionPasajes;
import com.formamosacero.services.CotizacionPasajesService;
import com.formamosacero.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cotizacion-pasajes")
public class CotizacionPasajesController {

    @Autowired
    private CotizacionPasajesService cotizacionPasajesService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listar(Model model) {
        List<CotizacionPasajes> cotizaciones = cotizacionPasajesService.obtenerTodos();
        model.addAttribute("cotizaciones", cotizaciones);
        return "cotizacionpasajes/lista";
    }

    @GetMapping("/new")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("cotizacionPasajes", new CotizacionPasajes());
        model.addAttribute("clientes", clienteService.obtenerTodos());
        return "cotizacionpasajes/formulario";
    }

    @PostMapping
    public String guardar(@ModelAttribute CotizacionPasajes cotizacionPasajes, RedirectAttributes redirectAttributes) {
        cotizacionPasajesService.guardar(cotizacionPasajes);
        redirectAttributes.addFlashAttribute("mensaje", "Cotización de Pasajes guardada exitosamente");
        return "redirect:/cotizacion-pasajes";
    }

    @GetMapping("/{id}")
    public String ver(@PathVariable Long id, Model model) {
        Optional<CotizacionPasajes> cotizacionPasajes = cotizacionPasajesService.obtenerPorId(id);
        if (cotizacionPasajes.isPresent()) {
            model.addAttribute("cotizacionPasajes", cotizacionPasajes.get());
            return "cotizacionpasajes/detalle";
        }
        return "redirect:/cotizacion-pasajes";
    }

    @GetMapping("/{id}/edit")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Optional<CotizacionPasajes> cotizacionPasajes = cotizacionPasajesService.obtenerPorId(id);
        if (cotizacionPasajes.isPresent()) {
            model.addAttribute("cotizacionPasajes", cotizacionPasajes.get());
            model.addAttribute("clientes", clienteService.obtenerTodos());
            return "cotizacionpasajes/formulario";
        }
        return "redirect:/cotizacion-pasajes";
    }

    @PostMapping("/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute CotizacionPasajes cotizacionPasajes, RedirectAttributes redirectAttributes) {
        CotizacionPasajes cotizacionActualizado = cotizacionPasajesService.actualizar(id, cotizacionPasajes);
        if (cotizacionActualizado != null) {
            redirectAttributes.addFlashAttribute("mensaje", "Cotización de Pasajes actualizada exitosamente");
        } else {
            redirectAttributes.addFlashAttribute("error", "Cotización de Pasajes no encontrada");
        }
        return "redirect:/cotizacion-pasajes";
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String eliminar(@PathVariable Long id) {
        try {
            cotizacionPasajesService.eliminar(id);
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
        List<CotizacionPasajes> cotizaciones;
        
        if (numero != null && !numero.isEmpty()) {
            CotizacionPasajes cotizacion = cotizacionPasajesService.buscarPorNumero(numero);
            cotizaciones = cotizacion != null ? List.of(cotizacion) : List.of();
        } else if (estado != null && !estado.isEmpty()) {
            cotizaciones = cotizacionPasajesService.buscarPorEstado(estado);
        } else if (fechaInicio != null && !fechaInicio.isEmpty() && fechaFin != null && !fechaFin.isEmpty()) {
            cotizaciones = cotizacionPasajesService.buscarPorRangoFechas(LocalDate.parse(fechaInicio), LocalDate.parse(fechaFin));
        } else {
            cotizaciones = cotizacionPasajesService.obtenerTodos();
        }
        
        model.addAttribute("cotizaciones", cotizaciones);
        return "cotizacionpasajes/lista";
    }
}
