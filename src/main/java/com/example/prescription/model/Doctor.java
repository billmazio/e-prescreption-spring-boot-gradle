package com.example.prescription.model;

import jakarta.persistence.*;
import lombok.*;


import javax.validation.constraints.*;

@SuppressWarnings("ALL")
@Entity
@Table(name = "DOCTOR")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Email(message = "invalid email address")
    private String email;
    //endregion
    @NotNull
    @Pattern(regexp ="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")
    private String password;
    @NotNull
    @Pattern(regexp ="^\\d{10}$",message = "invalid mobile number entered")
    private String phone;

}