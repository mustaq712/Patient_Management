package com.project.hospital.model;



import java.util.Date;

import com.project.hospital.controller.dto.PatientDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Patient {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;
    // Default no-argument constructor (required for JPA)
    public Patient() {
    }

    // Constructor with required fields
    public Patient(String firstName, String lastName, Date dateOfBirth, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    // Full constructor with all fields
    public Patient(PatientDTO patientDTO) {
        this.firstName = patientDTO.getFirstName();
        this.lastName = patientDTO.getLastName();
        this.dateOfBirth = patientDTO.getDateOfBirth();
        this.gender = patientDTO.getGender();
        this.phoneNumber = patientDTO.getPhoneNumber();
        this.email = patientDTO.getEmail();
        this.address = patientDTO.getAddress();
    }
    public void updateFromDTO(PatientDTO patientDTO) {
        this.firstName = patientDTO.getFirstName();
        this.lastName = patientDTO.getLastName();
        this.dateOfBirth = patientDTO.getDateOfBirth();
        this.gender = patientDTO.getGender();
        this.phoneNumber = patientDTO.getPhoneNumber();
        this.email = patientDTO.getEmail();
        this.address = patientDTO.getAddress();
    }
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Patient {id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", address=" + address + "}";
	}


}
