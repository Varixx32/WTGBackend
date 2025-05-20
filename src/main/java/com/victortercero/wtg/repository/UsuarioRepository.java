package com.victortercero.wtg.repository;

import com.victortercero.wtg.model.UsuarioApp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<UsuarioApp, UUID> {
}
