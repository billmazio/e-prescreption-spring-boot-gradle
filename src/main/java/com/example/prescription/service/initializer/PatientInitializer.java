package com.example.prescription.service.initializer;

import com.example.prescription.model.Patient;
import com.example.prescription.repository.DrugRepository;
import com.example.prescription.repository.PatientRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Set;

@Service
@Order(2)
public class PatientInitializer implements ApplicationRunner {
    private final PatientRepository patientRepository;
    private final DrugRepository drugRepository;

    public PatientInitializer(PatientRepository patientRepository,
                              DrugRepository drugRepository) {
        this.patientRepository = patientRepository;
        this.drugRepository = drugRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) {

        Patient candice = Patient.builder()
                .firstName("")
                .lastName("")
                .email("")
                .amka("")
                .phone("")
                .city("")
                .build();
       // candice.setDrugs(Set.of(Objects.requireNonNull(drugRepository.findById(1L).orElse(null))));

        //patientRepository.saveAll(Set.of(candice));
    }
}
