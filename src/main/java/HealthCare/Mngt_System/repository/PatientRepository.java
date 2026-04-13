package HealthCare.Mngt_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import HealthCare.Mngt_System.model.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long>{

}
