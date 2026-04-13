package HealthCare.Mngt_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HealthCare.Mngt_System.model.Doctor;
import HealthCare.Mngt_System.repository.DoctorRepository;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor saveDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }
    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }
    public Doctor updateDoctor(Long id, Doctor doctor) {
        Doctor existingDoctor=doctorRepository.findById(id).orElse(null);
        
        if(existingDoctor!=null){
            existingDoctor.setName(doctor.getName());
            existingDoctor.setSpecialization(doctor.getSpecialization());
            return doctorRepository.save(existingDoctor);
        }
        return null;
    }
    public void deleteDoctor(Long id){
        doctorRepository.deleteById(id);
    }
}
