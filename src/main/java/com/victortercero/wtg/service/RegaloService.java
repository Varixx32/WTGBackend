package com.victortercero.wtg.service;

import com.victortercero.wtg.model.Regalo;
import com.victortercero.wtg.repository.RegaloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegaloService {

    private final RegaloRepository regaloRepository;

    public RegaloService(RegaloRepository regaloRepository) {
        this.regaloRepository = regaloRepository;
    }

    public List<Regalo> getAll() {
        return regaloRepository.findAll();
    }

    public Optional<Regalo> getById(Long id) {
        return regaloRepository.findById(id);
    }

    public Regalo save(Regalo regalo) {
        return regaloRepository.save(regalo);
    }

    public Regalo update(Long id, Regalo regaloDetails) {
        return regaloRepository.findById(id).map(regalo -> {
            regalo.setNombre(regaloDetails.getNombre());
            regalo.setDescripcion(regaloDetails.getDescripcion());
            regalo.setUrlProducto(regaloDetails.getUrlProducto());
            regalo.setPrecio(regaloDetails.getPrecio());
            regalo.setCategoria(regaloDetails.getCategoria());
            return regaloRepository.save(regalo);
        }).orElseThrow(() -> new RuntimeException("Regalo no encontrado"));
    }

    public void delete(Long id) {
        regaloRepository.deleteById(id);
    }
}
