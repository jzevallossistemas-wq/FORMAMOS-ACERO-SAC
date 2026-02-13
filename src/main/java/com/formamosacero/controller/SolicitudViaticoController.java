package com.formamosacero.controller;

import com.formamosacero.models.SolicitudViatico;
import com.formamosacero.services.SolicitudViaticoService;
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
@RequestMapping("/solicitud-viatico")
public class SolicitudViaticoController {

    @Autowired
    private SolicitudViaticoService solicitudViaticoService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listar(Model model) {
        List<SolicitudViatico> solicitudes = solicitudViaticoService.obtenerTodos();
        model.addAttribute("solicitudes", solicitudes);
        return "solicitudviatico/lista";
    }

    @GetMapping("/new")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("solicitudViatico", new SolicitudViatico());
        model.addAttribute("clientes", clienteService.obtenerTodos());
        return "solicitudviatico/formulario";
    }

    @PostMapping
    public String guardar(@ModelAttribute SolicitudViatico solicitudViatico, RedirectAttributes redirectAttributes) {
        solicitudViaticoService.guardar(solicitudViatico);
        redirectAttributes.addFlashAttribute("mensaje", "Solicitud de Viático guardada exitosamente");
        return "redirect:/solicitud-viatico";
    }

    @GetMapping("/{id}")
    public String ver(@PathVariable Long id, Model model) {
        Optional<SolicitudViatico> solicitudViatico = solicitudViaticoService.obtenerPorId(id);
        if (solicitudViatico.isPresent()) {
            model.addAttribute("solicitudViatico", solicitudViatico.get());
            return "solicitudviatico/detalle";
        }
        return "redirect:/solicitud-viatico";
    }

    @GetMapping("/{id}/edit")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Optional<SolicitudViatico> solicitudViatico = solicitudViaticoService.obtenerPorId(id);
        if (solicitudViatico.isPresent()) {
            model.addAttribute("solicitudViatico", solicitudViatico.get());
            model.addAttribute("clientes", clienteService.obtenerTodos());
            return "solicitudviatico/formulario";
        }
        return "redirect:/solicitud-viatico";
    }

    @PostMapping("/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute SolicitudViatico solicitudViatico, RedirectAttributes redirectAttributes) {
        SolicitudViatico solicitudActualizado = solicitudViaticoService.actualizar(id, solicitudViatico);
        if (solicitudActualizado != null) {
            redirectAttributes.addFlashAttribute("mensaje", "Solicitud de Viático actualizada exitosamente");
        } else {
            redirectAttributes.addFlashAttribute("error", "Solicitud de Viático no encontrada");
        }
        return "redirect:/solicitud-viatico";
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String eliminar(@PathVariable Long id) {
        try {
            solicitudViaticoService.eliminar(id);
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
        List<SolicitudViatico> solicitudes;
        
        if (numero != null && !numero.isEmpty()) {
            SolicitudViatico solicitud = solicitudViaticoService.buscarPorNumero(numero);
            solicitudes = solicitud != null ? List.of(solicitud) : List.of();
        } else if (estado != null && !estado.isEmpty()) {
            solicitudes = solicitudViaticoService.buscarPorEstado(estado);
        } else if (fechaInicio != null && !fechaInicio.isEmpty() && fechaFin != null && !fechaFin.isEmpty()) {
            solicitudes = solicitudViaticoService.buscarPorRangoFechas(LocalDate.parse(fechaInicio), LocalDate.parse(fechaFin));
        } else {
            solicitudes = solicitudViaticoService.obtenerTodos();
        }
        
        model.addAttribute("solicitudes", solicitudes);
        return "solicitudviatico/lista";
    }
}
