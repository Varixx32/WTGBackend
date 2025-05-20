package com.victortercero.wtg.service;

import com.victortercero.wtg.model.Categoria;
import com.victortercero.wtg.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> getAll() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> getById(Long id) {
        return categoriaRepository.findById(id);
    }

    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria update(Long id, Categoria categoriaDetails) {
        return categoriaRepository.findById(id).map(categoria -> {
            categoria.setNombre(categoriaDetails.getNombre());
            return categoriaRepository.save(categoria);
        }).orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
    }

    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }
}
