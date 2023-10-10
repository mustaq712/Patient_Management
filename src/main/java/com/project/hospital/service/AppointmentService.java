package com.project.hospital.service;

import com.project.hospital.controller.dto.AppointmentDTO;
import com.project.hospital.model.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment createAppointment(AppointmentDTO appointmentDTO);
    List<Appointment> getAppointmentsByPatientId(Long patientId);
   
}
