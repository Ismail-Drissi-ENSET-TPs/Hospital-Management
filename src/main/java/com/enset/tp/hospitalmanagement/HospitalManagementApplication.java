package com.enset.tp.hospitalmanagement;

import com.enset.tp.hospitalmanagement.entities.*;
import com.enset.tp.hospitalmanagement.repositories.ConsultationRepository;
import com.enset.tp.hospitalmanagement.repositories.MedecinRepository;
import com.enset.tp.hospitalmanagement.repositories.PatientRepository;
import com.enset.tp.hospitalmanagement.repositories.RendezVousRepository;
import com.enset.tp.hospitalmanagement.services.HospitalServiceImpl;
import com.enset.tp.hospitalmanagement.services.IHospitalService;
import jdk.jshell.Snippet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalManagementApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(IHospitalService hospitalService) {
        return args -> {
            Stream.of("Aziz", "Ismail", "Abdo").forEach(
                    name-> {
                        Patient patient = new Patient();
                        patient.setName(name);
                        patient.setBirthday(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
                    }
            );

            Stream.of("Aziz", "Ismail", "Abdo").forEach(
                    name-> {
                        Medecin medecin = new Medecin();
                        medecin.setName(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5?"A":"B");
                        hospitalService.saveMedecin(medecin);
                    }
            );

            Patient patient = hospitalService.getPatientById(1L);

            Medecin medecin = hospitalService.getMedecinById(1L);

            RendezVous rendezVous = new RendezVous();
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            rendezVous.setDate(new Date());
            rendezVous.setStatusRV(StatusRV.APPROVED);
            hospitalService.saveRendezVous(rendezVous);


            RendezVous rendezVous1 = hospitalService.getRendezVous(1L);
            Consultation consultation = new Consultation();
            consultation.setDate(new Date());
            consultation.setRapport("Good!");
            consultation.setRendezVous(rendezVous1);
            hospitalService.saveConsultation(consultation);
        };
    }

}
