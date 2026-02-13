package com.formamosacero.controller;

import com.formamosacero.models.SolicitudEfectivo;
import com.formamosacero.services.SolicitudEfectivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/solicitud-efectivo")
public class SolicitudEfectivoController {

    @Autowired
    private SolicitudEfectivoService solicitudEfectivoService;

    @GetMapping
    public String listar(Model model) {
        List<SolicitudEfectivo> solicitudes = solicitudEfectivoService.obtenerTodos();
        model.addAttribute("solicitudes", solicitudes);
        return "solicitudEfectivo/lista";
    }

    @GetMapping("/new")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("solicitudEfectivo", new SolicitudEfectivo());
        return "solicitudEfectivo/formulario";
    }

    @PostMapping
    public String guardar(@ModelAttribute SolicitudEfectivo solicitudEfectivo, RedirectAttributes redirectAttributes) {
        solicitudEfectivoService.guardar(solicitudEfectivo);
        redirectAttributes.addFlashAttribute("mensaje", "Solicitud de Efectivo guardada exitosamente");
        return "redirect:/solicitud-efectivo";
    }

    @GetMapping("/{id}")
    public String ver(@PathVariable Long id, Model model) {
        Optional<SolicitudEfectivo> solicitudEfectivo = solicitudEfectivoService.obtenerPorId(id);
        if (solicitudEfectivo.isPresent()) {
            model.addAttribute("solicitudEfectivo", solicitudEfectivo.get());
            return "solicitudEfectivo/detalle";
        }
        return "redirect:/solicitud-efectivo";
    }

    @GetMapping("/{id}/edit")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Optional<SolicitudEfectivo> solicitudEfectivo = solicitudEfectivoService.obtenerPorId(id);
        if (solicitudEfectivo.isPresent()) {
            model.addAttribute("solicitudEfectivo", solicitudEfectivo.get());
            return "solicitudEfectivo/formulario";
        }
        return "redirect:/solicitud-efectivo";
    }

    @PostMapping("/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute SolicitudEfectivo solicitudEfectivo, RedirectAttributes redirectAttributes) {
        SolicitudEfectivo solicitudActualizado = solicitudEfectivoService.actualizar(id, solicitudEfectivo);
        if (solicitudActualizado != null) {
            redirectAttributes.addFlashAttribute("mensaje", "Solicitud de Efectivo actualizada exitosamente");
        } else {
            redirectAttributes.addFlashAttribute("error", "Solicitud de Efectivo no encontrada");
        }
        return "redirect:/solicitud-efectivo";
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String eliminar(@PathVariable Long id) {
        try {
            solicitudEfectivoService.eliminar(id);
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
        List<SolicitudEfectivo> solicitudes;
        
        if (numero != null && !numero.isEmpty()) {
            SolicitudEfectivo solicitud = solicitudEfectivoService.buscarPorNumero(numero);
            solicitudes = solicitud != null ? List.of(solicitud) : List.of();
        } else if (estado != null && !estado.isEmpty()) {
            solicitudes = solicitudEfectivoService.buscarPorEstado(estado);
        } else if (fechaInicio != null && !fechaInicio.isEmpty() && fechaFin != null && !fechaFin.isEmpty()) {
            solicitudes = solicitudEfectivoService.buscarPorRangoFechas(LocalDate.parse(fechaInicio), LocalDate.parse(fechaFin));
        } else {
            solicitudes = solicitudEfectivoService.obtenerTodos();
        }
        
        model.addAttribute("solicitudes", solicitudes);
        return "solicitudEfectivo/lista";
    }
}
