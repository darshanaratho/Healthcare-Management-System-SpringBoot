package HealthCare.Mngt_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HealthCare.Mngt_System.model.Appointment;
import HealthCare.Mngt_System.model.Doctor;
import HealthCare.Mngt_System.model.Patient;
import HealthCare.Mngt_System.repository.AppointmentRepository;
import HealthCare.Mngt_System.repository.DoctorRepository;
import HealthCare.Mngt_System.repository.PatientRepository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repo;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired 
    private DoctorRepository doctorRepository;

    public Appointment saveAppointment(Appointment a) {

        Patient patient = patientRepository.findById(a.getPatient().getId()).orElse(null);

        Doctor doctor = doctorRepository.findById(a.getDoctor().getId()).orElse(null);

        a.setPatient(patient);
    a   .setDoctor(doctor);

        return repo.save(a);
    }

   
    public List<Appointment> getAllAppointments() {
        return repo.findAll();
    }


    public void deleteAppointment(int id) {
        repo.deleteById(id);
    }
}