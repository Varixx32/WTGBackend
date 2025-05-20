package com.victortercero.wtg.model;

//Subclase necesaria para funcionar con UUID de Supabase

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class AmistadId implements Serializable {

    private UUID idUsuario1;
    private UUID idUsuario2;

    public AmistadId() {}

    public AmistadId(UUID idUsuario1, UUID idUsuario2) {
        this.idUsuario1 = idUsuario1;
        this.idUsuario2 = idUsuario2;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AmistadId)) return false;
        AmistadId that = (AmistadId) o;
        return Objects.equals(idUsuario1, that.idUsuario1) &&
               Objects.equals(idUsuario2, that.idUsuario2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario1, idUsuario2);
    }
}
