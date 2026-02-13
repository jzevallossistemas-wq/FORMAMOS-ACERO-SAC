package com.formamosacero.controller;

import com.formamosacero.models.Cliente;
import com.formamosacero.models.PreOrden;
import com.formamosacero.models.Proveedor;
import com.formamosacero.services.ClienteService;
import com.formamosacero.services.PreOrdenService;
import com.formamosacero.services.ProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/preorden")
@RequiredArgsConstructor
public class PreOrdenController {

    private final PreOrdenService preOrdenService;
    private final ClienteService clienteService;
    private final ProveedorService proveedorService;

    @GetMapping
    public String list(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "10") int size,
                       Model model) {
        Page<PreOrden> preOrdenPage = preOrdenService.findAll(PageRequest.of(page, size));
        model.addAttribute("preOrdenes", preOrdenPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", preOrdenPage.getTotalPages());
        model.addAttribute("totalItems", preOrdenPage.getTotalElements());
        model.addAttribute("pageTitle", "Pre Órdenes - FORMAMOS ACERO SAC");
        return "preorden/lista";
    }

    @GetMapping("/nueva")
    public String showCreateForm(Model model) {
        PreOrden preOrden = new PreOrden();
        preOrden.setNumero(preOrdenService.generateNextNumero());
        preOrden.setFecha(LocalDate.now());
        preOrden.setMoneda("PEN");
        preOrden.setEstado("PENDIENTE");
        
        List<Cliente> clientes = clienteService.findAll();
        List<Proveedor> proveedores = proveedorService.findAll();
        
        model.addAttribute("preOrden", preOrden);
        model.addAttribute("clientes", clientes);
        model.addAttribute("proveedores", proveedores);
        model.addAttribute("pageTitle", "Nueva Pre Orden");
        model.addAttribute("isEdit", false);
        return "preorden/formulario";
    }

    @PostMapping("/guardar")
    public String save(@Valid @ModelAttribute PreOrden preOrden,
                       BindingResult result,
                       RedirectAttributes redirectAttributes,
                       Model model) {
        if (result.hasErrors()) {
            List<Cliente> clientes = clienteService.findAll();
            List<Proveedor> proveedores = proveedorService.findAll();
            model.addAttribute("clientes", clientes);
            model.addAttribute("proveedores", proveedores);
            model.addAttribute("pageTitle", "Nueva Pre Orden");
            model.addAttribute("isEdit", false);
            return "preorden/formulario";
        }

        preOrden.setUsuarioCreacion("admin"); // TODO: Get from authentication
        preOrdenService.save(preOrden);
        redirectAttributes.addFlashAttribute("success", "Pre Orden creada exitosamente");
        return "redirect:/preorden";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        return preOrdenService.findById(id)
                .map(preOrden -> {
                    List<Cliente> clientes = clienteService.findAll();
                    List<Proveedor> proveedores = proveedorService.findAll();
                    
                    model.addAttribute("preOrden", preOrden);
                    model.addAttribute("clientes", clientes);
                    model.addAttribute("proveedores", proveedores);
                    model.addAttribute("pageTitle", "Editar Pre Orden");
                    model.addAttribute("isEdit", true);
                    return "preorden/formulario";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("error", "Pre Orden no encontrada");
                    return "redirect:/preorden";
                });
    }

    @PostMapping("/actualizar/{id}")
    public String update(@PathVariable Long id,
                         @Valid @ModelAttribute PreOrden preOrden,
                         BindingResult result,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        if (result.hasErrors()) {
            List<Cliente> clientes = clienteService.findAll();
            List<Proveedor> proveedores = proveedorService.findAll();
            model.addAttribute("clientes", clientes);
            model.addAttribute("proveedores", proveedores);
            model.addAttribute("pageTitle", "Editar Pre Orden");
            model.addAttribute("isEdit", true);
            return "preorden/formulario";
        }

        preOrden.setUsuarioModificacion("admin"); // TODO: Get from authentication
        PreOrden updated = preOrdenService.update(id, preOrden);
        
        if (updated != null) {
            redirectAttributes.addFlashAttribute("success", "Pre Orden actualizada exitosamente");
        } else {
            redirectAttributes.addFlashAttribute("error", "Error al actualizar Pre Orden");
        }
        
        return "redirect:/preorden";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            preOrdenService.deleteById(id);
            redirectAttributes.addFlashAttribute("success", "Pre Orden eliminada exitosamente");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al eliminar Pre Orden: " + e.getMessage());
        }
        return "redirect:/preorden";
    }

    @GetMapping("/ver/{id}")
    public String view(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        return preOrdenService.findById(id)
                .map(preOrden -> {
                    model.addAttribute("preOrden", preOrden);
                    model.addAttribute("pageTitle", "Ver Pre Orden");
                    return "preorden/ver";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("error", "Pre Orden no encontrada");
                    return "redirect:/preorden";
                });
    }
}
