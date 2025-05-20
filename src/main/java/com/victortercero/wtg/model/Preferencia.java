package com.victortercero.wtg.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "preferencias")
@Getter @Setter
public class Preferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPreferencia;

    @Column(name = "id_usuario")
    private UUID idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
}
