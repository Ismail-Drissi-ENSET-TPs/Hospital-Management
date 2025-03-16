package com.enset.tp.hospitalmanagement.repositories;

import com.enset.tp.hospitalmanagement.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
