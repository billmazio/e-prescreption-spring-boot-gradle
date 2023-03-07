package com.example.prescription.model;


import jakarta.persistence.*;
import lombok.*;



import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "DRUG")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Drug {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE,}, mappedBy = "drugs")
    private Set<Patient> patients;
    private LocalDate prescribedOn;

}
