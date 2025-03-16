package com.enset.tp.hospitalmanagement.services;

import com.enset.tp.hospitalmanagement.entities.Consultation;
import com.enset.tp.hospitalmanagement.entities.Medecin;
import com.enset.tp.hospitalmanagement.entities.Patient;
import com.enset.tp.hospitalmanagement.entities.RendezVous;
import com.enset.tp.hospitalmanagement.repositories.ConsultationRepository;
import com.enset.tp.hospitalmanagement.repositories.MedecinRepository;
import com.enset.tp.hospitalmanagement.repositories.PatientRepository;
import com.enset.tp.hospitalmanagement.repositories.RendezVousRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private final PatientRepository patientRepository;
    private final MedecinRepository medecinRepository;
    private final ConsultationRepository consultationRepository;
    private final RendezVousRepository rendezVousRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository,
                               ConsultationRepository consultationRepository, RendezVousRepository rendezVousRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.consultationRepository = consultationRepository;
        this.rendezVousRepository = rendezVousRepository;
    }

    @Override
    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void saveMedecin(Medecin medecin) {
        medecinRepository.save(medecin);
    }

    @Override
    public void saveConsultation(Consultation consultation) {
        consultationRepository.save(consultation);
    }

    @Override
    public void saveRendezVous(RendezVous rendezVous) {
        rendezVousRepository.save(rendezVous);
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Medecin getMedecinById(Long id) {
        return medecinRepository.findById(id).orElse(null);
    }

    @Override
    public Consultation getConsultationById(Long id) {
        return consultationRepository.findById(id).orElse(null);
    }

    @Override
    public RendezVous getRendezVous(Long id) {
        return rendezVousRepository.findById(id).orElse(null);
    }

    @Override
    public void updatePatient(Patient patient) {
        if (patientRepository.existsById(patient.getId())) {
            patientRepository.save(patient);
        }
    }

    @Override
    public void updateMedecin(Medecin medecin) {
        if (medecinRepository.existsById(medecin.getId())) {
            medecinRepository.save(medecin);
        }
    }

    @Override
    public void updateConsultation(Consultation consultation) {
        if (consultationRepository.existsById(consultation.getId())) {
            consultationRepository.save(consultation);
        }
    }

    @Override
    public void updateRendezVous(RendezVous rendezVous) {
        if (rendezVousRepository.existsById(rendezVous.getId())) {
            rendezVousRepository.save(rendezVous);
        }
    }

    @Override
    public void deletePatientById(Long id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
        }
    }

    @Override
    public void deleteMedecinById(Long id) {
        if (medecinRepository.existsById(id)) {
            medecinRepository.deleteById(id);
        }
    }

    @Override
    public void deleteConsultationById(Long id) {
        if (consultationRepository.existsById(id)) {
            consultationRepository.deleteById(id);
        }
    }

    @Override
    public void deleteRendezVous(Long id) {
        if (rendezVousRepository.existsById(id)) {
            rendezVousRepository.deleteById(id);
        }
    }
}
