package com.example.demo.service;

import com.example.demo.entity.Preorden;
import com.example.demo.repository.PreordenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreordenService {

    @Autowired
    private PreordenRepository preordenRepository;

    public Preorden createPreorden(Preorden preorden) {
        return preordenRepository.save(preorden);
    }

    public List<Preorden> getAllPreordenes() {
        return preordenRepository.findAll();
    }

    public Preorden getPreordenById(Long id) {
        Optional<Preorden> preorden = preordenRepository.findById(id);
        return preorden.orElse(null);
    }

    public Preorden updatePreorden(Long id, Preorden preordenDetails) {
        Optional<Preorden> preorden = preordenRepository.findById(id);
        if (preorden.isPresent()) {
            Preorden existingPreorden = preorden.get();
            if (preordenDetails.getNumero() != null) {
                existingPreorden.setNumero(preordenDetails.getNumero());
            }
            if (preordenDetails.getFecha() != null) {
                existingPreorden.setFecha(preordenDetails.getFecha());
            }
            return preordenRepository.save(existingPreorden);
        }
        return null;
    }

    public void deletePreorden(Long id) {
        preordenRepository.deleteById(id);
    }
}