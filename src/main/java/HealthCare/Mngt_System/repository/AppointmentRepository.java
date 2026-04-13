package HealthCare.Mngt_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import HealthCare.Mngt_System.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    
}
