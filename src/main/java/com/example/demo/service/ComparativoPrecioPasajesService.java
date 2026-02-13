package com.example.demo.service;

import com.example.demo.entity.ComparativoPrecioPasajes;
import com.example.demo.repository.ComparativoPrecioPasajesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComparativoPrecioPasajesService {

    @Autowired
    private ComparativoPrecioPasajesRepository comparativoPrecioPasajesRepository;

    public ComparativoPrecioPasajes create(ComparativoPrecioPasajes comparativoPrecioPasajes) {
        return comparativoPrecioPasajesRepository.save(comparativoPrecioPasajes);
    }

    public List<ComparativoPrecioPasajes> getAll() {
        return comparativoPrecioPasajesRepository.findAll();
    }

    public ComparativoPrecioPasajes getById(Long id) {
        Optional<ComparativoPrecioPasajes> comparativoPrecioPasajes = comparativoPrecioPasajesRepository.findById(id);
        return comparativoPrecioPasajes.orElse(null);
    }

    public ComparativoPrecioPasajes update(Long id, ComparativoPrecioPasajes comparativoPrecioPasajesDetails) {
        Optional<ComparativoPrecioPasajes> comparativoPrecioPasajes = comparativoPrecioPasajesRepository.findById(id);
        if (comparativoPrecioPasajes.isPresent()) {
            ComparativoPrecioPasajes existing = comparativoPrecioPasajes.get();
            if (comparativoPrecioPasajesDetails.getOrigen() != null) {
                existing.setOrigen(comparativoPrecioPasajesDetails.getOrigen());
            }
            if (comparativoPrecioPasajesDetails.getDestino() != null) {
                existing.setDestino(comparativoPrecioPasajesDetails.getDestino());
            }
            return comparativoPrecioPasajesRepository.save(existing);
        }
        return null;
    }

    public void delete(Long id) {
        comparativoPrecioPasajesRepository.deleteById(id);
    }
}