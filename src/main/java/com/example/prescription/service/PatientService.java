package com.example.prescription.service;

import com.example.prescription.model.Patient;
import com.example.prescription.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Transactional(readOnly = true)
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }

    @Transactional
    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    @Transactional
    public void delete(Patient patient) {
        patientRepository.delete(patient);
    }
}
