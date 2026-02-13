package com.formamosacero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.formamosacero.model.Cliente;
import com.formamosacero.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Endpoint to list clientes with pagination
    @GetMapping
    public ModelAndView listClientes(@RequestParam(defaultValue = "0") int page) {
        Page<Cliente> clientes = clienteService.findAll(PageRequest.of(page, 10));
        ModelAndView mav = new ModelAndView("cliente/list");
        mav.addObject("clientes", clientes);
        return mav;
    }

    // Endpoint to show create form
    @GetMapping("/nuevo")
    public String showCreateForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente/create";
    }

    // Endpoint to save new cliente
    @PostMapping
    public String saveCliente(@ModelAttribute Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente";
    }

    // Endpoint to show edit form
    @GetMapping("/{id}/editar")
    public String showEditForm(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.findById(id);
        model.addAttribute("cliente", cliente);
        return "cliente/edit";
    }

    // Endpoint to update cliente
    @PostMapping("/{id}")
    public String updateCliente(@PathVariable Long id, @ModelAttribute Cliente cliente) {
        cliente.setId(id);
        clienteService.update(cliente);
        return "redirect:/cliente";
    }

    // Endpoint to delete cliente
    @GetMapping("/{id}/eliminar")
    public String deleteCliente(@PathVariable Long id) {
        clienteService.delete(id);
        return "redirect:/cliente";
    }
}
