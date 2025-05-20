package com.victortercero.wtg.repository;

import com.victortercero.wtg.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
