package HealthCare.Mngt_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import HealthCare.Mngt_System.model.Appointment;
import HealthCare.Mngt_System.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
@CrossOrigin

public class AppointmentController {
    @Autowired
    private AppointmentService service;

    // Create the appointment
    @PostMapping
    public Appointment addAppointment(@RequestBody Appointment a) {
        return service.saveAppointment(a);
    }

    // Read the value
    @GetMapping
    public List<Appointment> getAppointments() {
        return service.getAllAppointments();
    }

    // Delete the appointment
    @DeleteMapping("/{id}")
    public String deleteAppointment(@PathVariable int id) {
        service.deleteAppointment(id);
        return "Appointment deleted successfully......!!!!!";
    }
}
