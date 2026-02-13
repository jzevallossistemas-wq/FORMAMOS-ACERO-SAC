package com.formamosacero.controller;

import com.formamosacero.models.Cliente;
import com.formamosacero.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listar(Model model) {
        List<Cliente> clientes = clienteService.obtenerTodos();
        model.addAttribute("clientes", clientes);
        return "cliente/lista";
    }

    @GetMapping("/new")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente/formulario";
    }

    @PostMapping
    public String guardar(@ModelAttribute Cliente cliente, RedirectAttributes redirectAttributes) {
        clienteService.guardar(cliente);
        redirectAttributes.addFlashAttribute("mensaje", "Cliente guardado exitosamente");
        return "redirect:/cliente";
    }

    @GetMapping("/{id}")
    public String ver(@PathVariable Long id, Model model) {
        Optional<Cliente> cliente = clienteService.obtenerPorId(id);
        if (cliente.isPresent()) {
            model.addAttribute("cliente", cliente.get());
            return "cliente/detalle";
        }
        return "redirect:/cliente";
    }

    @GetMapping("/{id}/edit")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Optional<Cliente> cliente = clienteService.obtenerPorId(id);
        if (cliente.isPresent()) {
            model.addAttribute("cliente", cliente.get());
            return "cliente/formulario";
        }
        return "redirect:/cliente";
    }

    @PostMapping("/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute Cliente cliente, RedirectAttributes redirectAttributes) {
        Cliente clienteActualizado = clienteService.actualizar(id, cliente);
        if (clienteActualizado != null) {
            redirectAttributes.addFlashAttribute("mensaje", "Cliente actualizado exitosamente");
        } else {
            redirectAttributes.addFlashAttribute("error", "Cliente no encontrado");
        }
        return "redirect:/cliente";
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String eliminar(@PathVariable Long id) {
        try {
            clienteService.eliminar(id);
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/search")
    public String buscar(@RequestParam(required = false) String dni,
                        @RequestParam(required = false) String ruc,
                        @RequestParam(required = false) String razonSocial,
                        @RequestParam(required = false) String estado,
                        Model model) {
        List<Cliente> clientes;
        
        if (dni != null && !dni.isEmpty()) {
            Cliente cliente = clienteService.buscarPorDni(dni);
            clientes = cliente != null ? List.of(cliente) : List.of();
        } else if (ruc != null && !ruc.isEmpty()) {
            Cliente cliente = clienteService.buscarPorRuc(ruc);
            clientes = cliente != null ? List.of(cliente) : List.of();
        } else if (razonSocial != null && !razonSocial.isEmpty()) {
            clientes = clienteService.buscarPorRazonSocial(razonSocial);
        } else if (estado != null && !estado.isEmpty()) {
            clientes = clienteService.buscarPorEstado(estado);
        } else {
            clientes = clienteService.obtenerTodos();
        }
        
        model.addAttribute("clientes", clientes);
        return "cliente/lista";
    }
}
