package com.victortercero.wtg.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "listas")
@Getter @Setter
public class Lista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLista;

    private String nombreLista;
    private String descripcion;

    @Column(name = "id_usuario")
    private UUID idUsuario;
}
