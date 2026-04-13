package HealthCare.Mngt_System.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import HealthCare.Mngt_System.model.Doctor;
import HealthCare.Mngt_System.service.DoctorService;

@RestController
@RequestMapping("/doctors")
@CrossOrigin
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }
    @GetMapping
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }
    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id,@RequestBody Doctor doctor){
        return doctorService.updateDoctor(id,doctor);
    }
    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable Long id){
        doctorService.deleteDoctor(id);
        return "Doctor deleted succesfully.......!!!";
    }
}
