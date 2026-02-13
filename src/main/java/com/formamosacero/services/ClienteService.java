package com.formamosacero.services;

import com.formamosacero.models.Cliente;
import com.formamosacero.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

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
            c.setDni(clienteDetails.getDni());
            c.setRuc(clienteDetails.getRuc());
            c.setRazonSocial(clienteDetails.getRazonSocial());
            c.setNombres(clienteDetails.getNombres());
            c.setApellidos(clienteDetails.getApellidos());
            c.setEmail(clienteDetails.getEmail());
            c.setTelefono(clienteDetails.getTelefono());
            c.setDireccion(clienteDetails.getDireccion());
            c.setCiudad(clienteDetails.getCiudad());
            c.setPais(clienteDetails.getPais());
            c.setArea(clienteDetails.getArea());
            c.setDepartamento(clienteDetails.getDepartamento());
            c.setEstado(clienteDetails.getEstado());
            return clienteRepository.save(c);
        }
        return null;
    }

    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente buscarPorDni(String dni) {
        return clienteRepository.findByDni(dni);
    }

    public Cliente buscarPorRuc(String ruc) {
        return clienteRepository.findByRuc(ruc);
    }

    public Cliente buscarPorEmail(String email) {
        return clienteRepository.findByEmail(email);
    }

    public List<Cliente> buscarPorRazonSocial(String razonSocial) {
        return clienteRepository.findByRazonSocialContainingIgnoreCase(razonSocial);
    }

    public List<Cliente> buscarPorNombres(String nombres) {
        return clienteRepository.findByNombresContainingIgnoreCase(nombres);
    }

    public List<Cliente> buscarPorEstado(String estado) {
        return clienteRepository.findByEstado(estado);
    }
}
