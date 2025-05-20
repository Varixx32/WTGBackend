package com.victortercero.wtg.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "usuarios_app")
@Getter @Setter
public class UsuarioApp {

    @Id
    private UUID id; // Coincide con auth.users de Supabase

    private String nombre;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
}
