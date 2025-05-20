package com.victortercero.wtg.service;

import com.victortercero.wtg.model.Amistad;
import com.victortercero.wtg.repository.AmistadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AmistadService {

    private final AmistadRepository amistadRepository;

    public AmistadService(AmistadRepository amistadRepository) {
        this.amistadRepository = amistadRepository;
    }

    public List<Amistad> getAll() {
        return amistadRepository.findAll();
    }

    public Optional<Amistad> getById(UUID idUsuario1, UUID idUsuario2) {
        return amistadRepository.findById(new AmistadId(idUsuario1, idUsuario2));
    }

    public Amistad save(Amistad amistad) {
        return amistadRepository.save(amistad);
    }

    public Amistad update(UUID idUsuario1, UUID idUsuario2, Amistad amistadDetails) {
        return amistadRepository.findById(new AmistadId(idUsuario1, idUsuario2)).map(amistad -> {
            amistad.setEstado(amistadDetails.getEstado());
            return amistadRepository.save(amistad);
        }).orElseThrow(() -> new RuntimeException("Amistad no encontrada"));
    }

    public void delete(UUID idUsuario1, UUID idUsuario2) {
        amistadRepository.deleteById(new AmistadId(idUsuario1, idUsuario2));
    }
}
