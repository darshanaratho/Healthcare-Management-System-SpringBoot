package HealthCare.Mngt_System.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;

    public Appointment(){

    }
}
