package com.example.prescription.model;



import jakarta.persistence.*;
import lombok.*;


import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Table(name = "PATIENT")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotBlank(message = "firstname shouldn't be null")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "lastname shouldn't be null")
    private String lastName;

    @Column(name = "dob")
    private String dateOfBirth;
    @Pattern(regexp ="^\\d{10}$",message = "invalid mobile number entered")
    private String phone;



    @NotEmpty(message = "Email may not be empty")
    @Size(min = 7, max = 50)
    @Email(message = "invalid email address")
    private String email;

    @Column(name = "fathers_name")
    private String fathersName;

    @Column(name = "mothers_name")
    private String mothersName;

    @Column(name = "amka")
    @Size(min = 11, max = 11)
    @Pattern(regexp = "^[0-9]+$", message = "AMKA must contain only numbers")
    private String amka;

    @Column(name = "id_card")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "ID must contain only letters and numbers")
    private String idCard;

    private String city;

    @Column(name = "postal_code")
    @Size(min = 5, max = 5)
    @Pattern(regexp = "^[0-9]+$", message = "PC must contain only numbers")
    private String postalCode;

    private String symptoms;

    private String pharmacy;

    @Column(name = "doctor_name")
    private String doctorsName;

    private String message;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "patient_drug", joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "drug_id"))
    private Set<Drug> drugs;

}