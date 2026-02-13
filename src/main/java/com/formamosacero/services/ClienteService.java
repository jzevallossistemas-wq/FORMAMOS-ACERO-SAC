package com.formamosacero.services;

import com.formamosacero.models.Cliente;
import com.formamosacero.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Page<Cliente> findAll(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public Optional<Cliente> findByDni(String dni) {
        return clienteRepository.findByDni(dni);
    }

    public Optional<Cliente> findByRuc(String ruc) {
        return clienteRepository.findByRuc(ruc);
    }

    public Optional<Cliente> findByDniOrRuc(String dniOrRuc) {
        return clienteRepository.findByDniOrRuc(dniOrRuc);
    }

    public List<Cliente> findByRazonSocial(String razonSocial) {
        return clienteRepository.findByRazonSocialContainingIgnoreCase(razonSocial);
    }

    public List<Cliente> findByEstado(String estado) {
        return clienteRepository.findByEstado(estado);
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente update(Long id, Cliente clienteDetails) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setDni(clienteDetails.getDni());
                    cliente.setRuc(clienteDetails.getRuc());
                    cliente.setRazonSocial(clienteDetails.getRazonSocial());
                    cliente.setNombres(clienteDetails.getNombres());
                    cliente.setApellidos(clienteDetails.getApellidos());
                    cliente.setEmail(clienteDetails.getEmail());
                    cliente.setTelefono(clienteDetails.getTelefono());
                    cliente.setDireccion(clienteDetails.getDireccion());
                    cliente.setCiudad(clienteDetails.getCiudad());
                    cliente.setPais(clienteDetails.getPais());
                    cliente.setArea(clienteDetails.getArea());
                    cliente.setDepartamento(clienteDetails.getDepartamento());
                    cliente.setEstado(clienteDetails.getEstado());
                    return clienteRepository.save(cliente);
                })
                .orElse(null);
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}
