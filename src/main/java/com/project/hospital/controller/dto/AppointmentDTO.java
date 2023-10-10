package com.project.hospital.controller.dto;

import java.util.Date;

public class AppointmentDTO {
    private Long patientId;
    private Date appointmentDate;
    
    public AppointmentDTO(Long patientId,Date appointmentDate) {
    	this.patientId = patientId;
    	this.appointmentDate = appointmentDate;
    }
    public AppointmentDTO() {
    	
    }
    
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
   
   
}
