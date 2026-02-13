package com.formamosacero.services;

import com.formamosacero.models.Cliente;
import com.formamosacero.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Page<Cliente> obtenerTodos(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obtenerPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente actualizar(Long id, Cliente clienteDetails) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            Cliente c = cliente.get();
            c.setNombre(clienteDetails.getNombre());
            c.setEmail(clienteDetails.getEmail());
            c.setTelefono(clienteDetails.getTelefono());
            c.setDireccion(clienteDetails.getDireccion());
            return clienteRepository.save(c);
        }
        return null;
    }

    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente buscarPorEmail(String email) {
        return clienteRepository.findByEmail(email);
    }

    public Cliente buscarPorNombre(String nombre) {
        return clienteRepository.findByNombre(nombre);
    }
}
