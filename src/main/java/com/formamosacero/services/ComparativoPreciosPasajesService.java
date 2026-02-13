package com.formamosacero.services;

import com.formamosacero.models.ComparativoPreciosPasajes;
import com.formamosacero.repositories.ComparativoPreciosPasajesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComparativoPreciosPasajesService {

    @Autowired
    private ComparativoPreciosPasajesRepository comparativoRepository;

    public Page<ComparativoPreciosPasajes> obtenerTodos(Pageable pageable) {
        return comparativoRepository.findAll(pageable);
    }

    public List<ComparativoPreciosPasajes> obtenerTodos() {
        return comparativoRepository.findAll();
    }

    public Optional<ComparativoPreciosPasajes> obtenerPorId(Long id) {
        return comparativoRepository.findById(id);
    }

    public ComparativoPreciosPasajes guardar(ComparativoPreciosPasajes comparativo) {
        return comparativoRepository.save(comparativo);
    }

    public ComparativoPreciosPasajes actualizar(Long id, ComparativoPreciosPasajes comparativoDetails) {
        Optional<ComparativoPreciosPasajes> comparativo = comparativoRepository.findById(id);
        if (comparativo.isPresent()) {
            ComparativoPreciosPasajes c = comparativo.get();
            c.setNumero(comparativoDetails.getNumero());
            c.setDestino(comparativoDetails.getDestino());
            c.setFechaComparacion(comparativoDetails.getFechaComparacion());
            c.setAerolinea1(comparativoDetails.getAerolinea1());
            c.setTotal1(comparativoDetails.getTotal1());
            c.setAerolinea2(comparativoDetails.getAerolinea2());
            c.setTotal2(comparativoDetails.getTotal2());
            c.setAerolinea3(comparativoDetails.getAerolinea3());
            c.setTotal3(comparativoDetails.getTotal3());
            c.setMejorOpcion(comparativoDetails.getMejorOpcion());
            c.setObservaciones(comparativoDetails.getObservaciones());
            return comparativoRepository.save(c);
        }
        return null;
    }

    public void eliminar(Long id) {
        comparativoRepository.deleteById(id);
    }
}
