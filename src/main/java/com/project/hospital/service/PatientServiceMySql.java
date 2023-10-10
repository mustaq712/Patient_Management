package com.project.hospital.service;

import com.project.hospital.controller.dto.PatientDTO;
import com.project.hospital.model.Patient;
import com.project.hospital.repository.PatientRepository;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceMySql implements PatientService {
	@Autowired
    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceMySql(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void delete(Long patientId) {
        patientRepository.deleteById(patientId);
    }

    @Override
    public List<Patient> all() {
        List<Patient> result = new ArrayList<>();
        patientRepository.findAll().forEach(result::add);
        return result;
    }
    @Override
    public Patient addPatient(PatientDTO patientDTO) {
  
        Patient patient = new Patient(patientDTO);

        
        return patientRepository.save(patient);
    }
    @Override
    public Patient findById(Long patientId) {
        return patientRepository.findById(patientId).orElse(null);
    }
    @Override
    public void deletePatient(Long id) {
      
        patientRepository.deleteById(id);
    }
    @Override
    public boolean checkPatientExists(Long patientId, String firstName, String lastName) {
        // Query the database to check if a patient with the given details exists
        Patient patient = patientRepository.findById(patientId).orElse(null);
        
        // Check if the patient exists and if the first name and last name match
        return patient != null &&
               patient.getFirstName().equals(firstName) &&
               patient.getLastName().equals(lastName);
    }
   
    @Override
    public Patient updatePatient(Long id, PatientDTO patientDTO) {
        java.util.Optional<Patient> optionalPatient = patientRepository.findById(id);

        if (optionalPatient.isPresent()) {
            // Patient with the specified ID exists, update its properties
            Patient patient = optionalPatient.get();
            patient.updateFromDTO(patientDTO);
            return patientRepository.save(patient);
        } else {
            // Patient with the specified ID does not exist, return null or handle accordingly
            return null;
        }
    }


}

