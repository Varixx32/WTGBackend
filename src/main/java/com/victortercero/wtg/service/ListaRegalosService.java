package com.victortercero.wtg.service;

import com.victortercero.wtg.model.Lista;
import com.victortercero.wtg.repository.ListaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListaService {

    private final ListaRepository listaRepository;

    public ListaService(ListaRepository listaRepository) {
        this.listaRepository = listaRepository;
    }

    // Obtener todas las listas
    public List<Lista> getAll() {
        return listaRepository.findAll();
    }

    // Obtener lista por ID
    public Optional<Lista> getById(Long id) {
        return listaRepository.findById(id);
    }

    // Crear una nueva lista
    public Lista save(Lista lista) {
        return listaRepository.save(lista);
    }

    // Actualizar lista existente
    public Lista update(Long id, Lista listaDetails) {
        return listaRepository.findById(id).map(lista -> {
            lista.setNombreLista(listaDetails.getNombreLista());
            lista.setDescripcion(listaDetails.getDescripcion());
            lista.setIdUsuario(listaDetails.getIdUsuario());
            return listaRepository.save(lista);
        }).orElseThrow(() -> new RuntimeException("Lista no encontrada"));
    }

    // Eliminar lista por ID
    public void delete(Long id) {
        listaRepository.deleteById(id);
    }

    // Puedes añadir métodos adicionales, por ejemplo:
    // Obtener listas por usuario
    public List<Lista> findByIdUsuario(java.util.UUID idUsuario) {
        return listaRepository.findByIdUsuario(idUsuario);
    }
}
