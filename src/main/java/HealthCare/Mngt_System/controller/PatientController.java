package HealthCare.Mngt_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import HealthCare.Mngt_System.model.Patient;
import HealthCare.Mngt_System.service.PatientService;

@RestController
@RequestMapping("/patients")
@CrossOrigin
public class PatientController{
    @Autowired
    private PatientService service;

    @PostMapping
    public Patient addPatient(@RequestBody Patient p) {
        return service.savePatient(p);
    }

    @GetMapping
    public List<Patient> getPatients() {
        return service.getAllPatients();
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient p) {
        return service.updatePatient(id, p);
    }

    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable Long id) {
        service.deletePatient(id);
        return "Patient deleted successfully";
    }
}
