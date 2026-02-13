package com.example.demo.service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElse(null);
    }

    public Cliente updateCliente(Long id, Cliente clienteDetails) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            Cliente existingCliente = cliente.get();
            if (clienteDetails.getNombre() != null) {
                existingCliente.setNombre(clienteDetails.getNombre());
            }
            if (clienteDetails.getEmail() != null) {
                existingCliente.setEmail(clienteDetails.getEmail());
            }
            if (clienteDetails.getTelefono() != null) {
                existingCliente.setTelefono(clienteDetails.getTelefono());
            }
            return clienteRepository.save(existingCliente);
        }
        return null;
    }

    public boolean deleteCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}