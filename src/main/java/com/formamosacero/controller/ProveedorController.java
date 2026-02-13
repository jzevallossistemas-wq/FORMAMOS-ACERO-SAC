package com.formamosacero.controller;

import com.formamosacero.models.Proveedor;
import com.formamosacero.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public String listar(Model model) {
        List<Proveedor> proveedores = proveedorService.obtenerTodos();
        model.addAttribute("proveedores", proveedores);
        return "proveedor/lista";
    }

    @GetMapping("/new")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        return "proveedor/formulario";
    }

    @PostMapping
    public String guardar(@ModelAttribute Proveedor proveedor, RedirectAttributes redirectAttributes) {
        proveedorService.guardar(proveedor);
        redirectAttributes.addFlashAttribute("mensaje", "Proveedor guardado exitosamente");
        return "redirect:/proveedor";
    }

    @GetMapping("/{id}")
    public String ver(@PathVariable Long id, Model model) {
        Optional<Proveedor> proveedor = proveedorService.obtenerPorId(id);
        if (proveedor.isPresent()) {
            model.addAttribute("proveedor", proveedor.get());
            return "proveedor/detalle";
        }
        return "redirect:/proveedor";
    }

    @GetMapping("/{id}/edit")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Optional<Proveedor> proveedor = proveedorService.obtenerPorId(id);
        if (proveedor.isPresent()) {
            model.addAttribute("proveedor", proveedor.get());
            return "proveedor/formulario";
        }
        return "redirect:/proveedor";
    }

    @PostMapping("/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute Proveedor proveedor, RedirectAttributes redirectAttributes) {
        Proveedor proveedorActualizado = proveedorService.actualizar(id, proveedor);
        if (proveedorActualizado != null) {
            redirectAttributes.addFlashAttribute("mensaje", "Proveedor actualizado exitosamente");
        } else {
            redirectAttributes.addFlashAttribute("error", "Proveedor no encontrado");
        }
        return "redirect:/proveedor";
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String eliminar(@PathVariable Long id) {
        try {
            proveedorService.eliminar(id);
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/search")
    public String buscar(@RequestParam(required = false) String ruc,
                        @RequestParam(required = false) String razonSocial,
                        Model model) {
        List<Proveedor> proveedores;
        
        if (ruc != null && !ruc.isEmpty()) {
            Proveedor proveedor = proveedorService.buscarPorRuc(ruc);
            proveedores = proveedor != null ? List.of(proveedor) : List.of();
        } else if (razonSocial != null && !razonSocial.isEmpty()) {
            Proveedor proveedor = proveedorService.buscarPorRazonSocial(razonSocial);
            proveedores = proveedor != null ? List.of(proveedor) : List.of();
        } else {
            proveedores = proveedorService.obtenerTodos();
        }
        
        model.addAttribute("proveedores", proveedores);
        return "proveedor/lista";
    }
}
