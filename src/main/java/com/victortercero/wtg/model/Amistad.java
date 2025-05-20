package com.victortercero.wtg.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "amigos")
@IdClass(AmistadId.class)
@Getter @Setter
public class Amistad {

    @Id
    private UUID idUsuario1;

    @Id
    private UUID idUsuario2;

    private String estado;
}
