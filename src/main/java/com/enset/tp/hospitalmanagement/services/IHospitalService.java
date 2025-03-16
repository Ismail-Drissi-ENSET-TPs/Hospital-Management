package com.enset.tp.hospitalmanagement.services;

import com.enset.tp.hospitalmanagement.entities.Consultation;
import com.enset.tp.hospitalmanagement.entities.Medecin;
import com.enset.tp.hospitalmanagement.entities.Patient;
import com.enset.tp.hospitalmanagement.entities.RendezVous;

public interface IHospitalService {
    void savePatient(Patient patient);
    void saveMedecin(Medecin medecin);
    void saveConsultation(Consultation consultation);
    void saveRendezVous(RendezVous rendezVous);

    Patient getPatientById(Long id);
    Medecin getMedecinById(Long id);
    Consultation getConsultationById(Long id);
    RendezVous getRendezVous(Long id);

    void updatePatient(Patient patient);
    void updateMedecin(Medecin medecin);
    void updateConsultation(Consultation consultation);
    void updateRendezVous(RendezVous rendezVous);

    void deletePatientById(Long id);
    void deleteMedecinById(Long id);
    void deleteConsultationById(Long id);
    void deleteRendezVous(Long id);
}
