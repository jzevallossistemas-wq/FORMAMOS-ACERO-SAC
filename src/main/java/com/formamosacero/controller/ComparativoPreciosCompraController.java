package com.formamosacero.controller;

import com.formamosacero.models.ComparativoPreciosCompra;
import com.formamosacero.services.ComparativoPreciosCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/comparativo-precios-compra")
public class ComparativoPreciosCompraController {

    @Autowired
    private ComparativoPreciosCompraService comparativoPreciosCompraService;

    @GetMapping
    public String listar(Model model) {
        List<ComparativoPreciosCompra> comparativos = comparativoPreciosCompraService.obtenerTodos();
        model.addAttribute("comparativos", comparativos);
        return "comparativoPreciosCompra/lista";
    }

    @GetMapping("/new")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("comparativoPreciosCompra", new ComparativoPreciosCompra());
        return "comparativoPreciosCompra/formulario";
    }

    @PostMapping
    public String guardar(@ModelAttribute ComparativoPreciosCompra comparativoPreciosCompra, RedirectAttributes redirectAttributes) {
        comparativoPreciosCompraService.guardar(comparativoPreciosCompra);
        redirectAttributes.addFlashAttribute("mensaje", "Comparativo de Precios de Compra guardado exitosamente");
        return "redirect:/comparativo-precios-compra";
    }

    @GetMapping("/{id}")
    public String ver(@PathVariable Long id, Model model) {
        Optional<ComparativoPreciosCompra> comparativoPreciosCompra = comparativoPreciosCompraService.obtenerPorId(id);
        if (comparativoPreciosCompra.isPresent()) {
            model.addAttribute("comparativoPreciosCompra", comparativoPreciosCompra.get());
            return "comparativoPreciosCompra/detalle";
        }
        return "redirect:/comparativo-precios-compra";
    }

    @GetMapping("/{id}/edit")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Optional<ComparativoPreciosCompra> comparativoPreciosCompra = comparativoPreciosCompraService.obtenerPorId(id);
        if (comparativoPreciosCompra.isPresent()) {
            model.addAttribute("comparativoPreciosCompra", comparativoPreciosCompra.get());
            return "comparativoPreciosCompra/formulario";
        }
        return "redirect:/comparativo-precios-compra";
    }

    @PostMapping("/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute ComparativoPreciosCompra comparativoPreciosCompra, RedirectAttributes redirectAttributes) {
        ComparativoPreciosCompra comparativoActualizado = comparativoPreciosCompraService.actualizar(id, comparativoPreciosCompra);
        if (comparativoActualizado != null) {
            redirectAttributes.addFlashAttribute("mensaje", "Comparativo de Precios de Compra actualizado exitosamente");
        } else {
            redirectAttributes.addFlashAttribute("error", "Comparativo de Precios de Compra no encontrado");
        }
        return "redirect:/comparativo-precios-compra";
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String eliminar(@PathVariable Long id) {
        try {
            comparativoPreciosCompraService.eliminar(id);
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
        List<ComparativoPreciosCompra> comparativos;
        
        if (numero != null && !numero.isEmpty()) {
            ComparativoPreciosCompra comparativo = comparativoPreciosCompraService.buscarPorNumero(numero);
            comparativos = comparativo != null ? List.of(comparativo) : List.of();
        } else if (estado != null && !estado.isEmpty()) {
            comparativos = comparativoPreciosCompraService.buscarPorEstado(estado);
        } else if (fechaInicio != null && !fechaInicio.isEmpty() && fechaFin != null && !fechaFin.isEmpty()) {
            comparativos = comparativoPreciosCompraService.buscarPorRangoFechas(LocalDate.parse(fechaInicio), LocalDate.parse(fechaFin));
        } else {
            comparativos = comparativoPreciosCompraService.obtenerTodos();
        }
        
        model.addAttribute("comparativos", comparativos);
        return "comparativoPreciosCompra/lista";
    }
}
