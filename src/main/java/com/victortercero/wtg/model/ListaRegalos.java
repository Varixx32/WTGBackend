package com.victortercero.wtg.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "regalos_listas")
@Getter @Setter
public class ListaRegalos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idLista;
    private Long idRegalo;
    private Boolean comprado;

    @Column(name = "comprado_por")
    private UUID compradoPor;
}
