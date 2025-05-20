package com.victortercero.wtg.repository;

import com.victortercero.wtg.model.Amistad;
import com.victortercero.wtg.model.AmistadId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AmistadRepository extends JpaRepository<Amistad, AmistadId> {
}
