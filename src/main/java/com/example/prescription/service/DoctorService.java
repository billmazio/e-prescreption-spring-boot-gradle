package com.example.prescription.service;

import com.example.prescription.model.Doctor;
import com.example.prescription.repository.DoctorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    @Transactional(readOnly = true)
    public Doctor login(String email, String password) {
        Doctor doctor =  doctorRepository.findByEmailAndPassword(email ,password);
        return doctor;
    }

    @Transactional
    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);

    }
}
