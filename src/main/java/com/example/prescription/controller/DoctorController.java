package com.example.prescription.controller;


import com.example.prescription.model.Doctor;

import com.example.prescription.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import javax.validation.Valid;


@Controller
@Slf4j
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("doctor",new Doctor());
        return "doctorLogin";
}
    @PostMapping("/login")
    public String login( @Valid @ModelAttribute("doctor")Doctor doctor , BindingResult result) {
        if (result.hasErrors()){
            log.debug("doctorLogin");
        }
    Doctor oauthDoctor =doctorService.login(doctor.getEmail(), doctor.getPassword());
    if(oauthDoctor!=null){
        return "redirect:/patients";
    }else {
        return "registration";
    }

}
    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("doctor",new Doctor());
    return "registration";
    }

    @PostMapping("/signUp")
    public String register(Doctor doctor) {
    Doctor doctor1 = doctorService.save(doctor);
    return "redirect:/login";
    }

}
