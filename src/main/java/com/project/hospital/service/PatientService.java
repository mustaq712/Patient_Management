package com.project.hospital.service;

import com.project.hospital.controller.dto.PatientDTO;
import com.project.hospital.model.Patient;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;



public interface PatientService {
    Patient save(Patient patient);

    void delete(Long patientId);

    List<Patient> all();

    Patient findById(Long patientId);

	Patient addPatient(PatientDTO patientDTO);
    
	void deletePatient(Long id);

	boolean checkPatientExists(Long patientId, String firstName, String lastName);
	
	public Patient updatePatient(Long id, PatientDTO patientDTO);
	
}
