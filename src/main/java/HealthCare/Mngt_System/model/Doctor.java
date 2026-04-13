package HealthCare.Mngt_System.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String specialization;

    public Doctor(){
        
    }
}
