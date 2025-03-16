package com.enset.tp.hospitalmanagement;

import com.enset.tp.hospitalmanagement.entities.*;
import com.enset.tp.hospitalmanagement.repositories.ConsultationRepository;
import com.enset.tp.hospitalmanagement.repositories.MedecinRepository;
import com.enset.tp.hospitalmanagement.repositories.PatientRepository;
import com.enset.tp.hospitalmanagement.repositories.RendezVousRepository;
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
    public CommandLineRunner run(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        return args -> {
            Stream.of("Aziz", "Ismail", "Abdo").forEach(
                    name-> {
                        Patient patient = new Patient();
                        patient.setName(name);
                        patient.setBirthday(new Date());
                        patient.setMalade(false);
                        patientRepository.save(patient);
                    }
            );

            Stream.of("Aziz", "Ismail", "Abdo").forEach(
                    name-> {
                        Medecin medecin = new Medecin();
                        medecin.setName(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5?"A":"B");
                        medecinRepository.save(medecin);
                    }
            );

            Patient patient = new Patient();
            patient.setBirthday(new Date());
            patient.setMalade(true);
            patient.setName("Omar");
            patientRepository.save(patient);

            Medecin medecin = new Medecin();
            medecin.setName("Yasmine");
            medecin.setEmail(medecin.getName()+"@gmail.com");
            medecin.setSpecialite(Math.random()>0.5?"A":"B");
            medecinRepository.save(medecin);

            RendezVous rendezVous = new RendezVous();
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            rendezVous.setDate(new Date());
            rendezVous.setStatusRV(StatusRV.APPROVED);
            rendezVousRepository.save(rendezVous);


            Consultation consultation = new Consultation();
            consultation.setDate(new Date());
            consultation.setRapport("Good!");
            consultation.setRendezVous(rendezVous);
            consultationRepository.save(consultation);
        };
    }

}
