package com.project.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.hospital.service.PatientService;
import com.project.hospital.model.Patient;

@Controller
@RequestMapping("/delete-patient")
public class DeletePatientController {

    private final PatientService patientService;

    @Autowired
    public DeletePatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public String showDeletePatientForm() {
        return "delete_patient"; // Return the name of the HTML page (delete_patient.html)
    }

    @PostMapping
    public String deletePatient(@RequestParam Long patientId, @RequestParam String firstName, @RequestParam String lastName, Model model) {
        // Check if a patient with the provided ID, first name, and last name exists
        boolean patientExists = patientService.checkPatientExists(patientId, firstName, lastName);

        if (patientExists) {
            // Delete the patient record from the database
            patientService.deletePatient(patientId);
            
            // Redirect to a success page or display a confirmation message
            return "redirect:/delete-patient/success"; // Redirect to a success page
        } else {
            // If the patient does not exist, display an error message
            model.addAttribute("errorMessage", "Patient not found. Please check the provided details.");
            return "delete_patient"; // Return to the delete_patient.html page with an error message
        }
    }
}
