package HealthCare.Mngt_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HealthCare.Mngt_System.model.Patient;
import HealthCare.Mngt_System.repository.PatientRepository;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

  public Patient savePatient(Patient p) {
        return patientRepository.save(p);
    }

    // READ
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // UPDATE
    public Patient updatePatient(Long id, Patient newPatient) {
        Patient existing = patientRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(newPatient.getName());
            existing.setAge(newPatient.getAge());
            return patientRepository.save(existing);
        }
        return null;
    }

    // DELETE
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
