package com.enset.tp.hospitalmanagement.repositories;

import com.enset.tp.hospitalmanagement.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.concurrent.Future;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
}

