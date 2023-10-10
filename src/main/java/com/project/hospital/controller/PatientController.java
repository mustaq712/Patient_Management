package com.project.hospital.controller;

import com.project.hospital.controller.dto.PatientDTO;
import com.project.hospital.model.Patient;
import com.project.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/all")
    public Iterable<Patient> getAllPatients() {
        return patientService.all();
    }
    @PostMapping("/add")
    public ResponseEntity<Patient> addPatient(@RequestBody PatientDTO patientDTO) {
        Patient patient = patientService.addPatient(patientDTO);
        return new ResponseEntity<>(patient, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.findById(id);
    }

    @PostMapping
    public Patient savePatient(@RequestBody PatientDTO patientDTO) {
        return patientService.save(new Patient(patientDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody PatientDTO patientDTO) {
        Patient updatedPatient = patientService.updatePatient(id, patientDTO);
        if (updatedPatient != null) {
            return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.delete(id);
    }
}
