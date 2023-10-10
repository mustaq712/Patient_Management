//package com.project.hospital.service;
//
//import com.project.hospital.controller.dto.AppointmentDTO;
//import com.project.hospital.model.Appointment;
//import com.project.hospital.model.Patient;
//import com.project.hospital.repository.AppointmentRepository;
//import com.project.hospital.repository.PatientRepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class AppointmentServiceMySql implements AppointmentService {
//
//    private final AppointmentRepository appointmentRepository;
//
//    @Autowired
//    public AppointmentServiceMySql(AppointmentRepository appointmentRepository) {
//        this.appointmentRepository = appointmentRepository;
//    }
//    @Autowired
//    public AppointmentServiceMySql(AppointmentRepository appointmentRepository, PatientRepository patientRepository) {
//        this.appointmentRepository = appointmentRepository;
//        this.patientRepository = patientRepository;
//    }
//
//    @Override
//    public Appointment createAppointment(AppointmentDTO appointmentDTO) {
//    	 Optional<Patient> optionalPatient = patientRepository.findById(appointmentDTO.getPatientId());
//
//         if (optionalPatient.isPresent()) {
//          
//             Appointment appointment = new Appointment();
//             appointment.setPatient(optionalPatient.get());
//             appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
//
//             return appointmentRepository.save(appointment);
//         } else {
//             
//             return null;
//         }
//    }
//
//    @Override
//    public List<Appointment> getAppointmentsByPatientId(Long patientId) {
// 
//    	 return appointmentRepository.findByPatientId(patientId);
//    }
//
//    
//}
