package com.victortercero.wtg.service;

import com.victortercero.wtg.model.UsuarioApp;
import com.victortercero.wtg.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioAppService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioAppService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioApp> getAll() {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioApp> getById(UUID id) {
        return usuarioRepository.findById(id);
    }

    public UsuarioApp save(UsuarioApp usuarioApp) {
        return usuarioRepository.save(usuarioApp);
    }

    public UsuarioApp update(UUID id, UsuarioApp usuarioDetails) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNombre(usuarioDetails.getNombre());
            return usuarioRepository.save(usuario);
        }).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public void delete(UUID id) {
        usuarioRepository.deleteById(id);
    }
}
